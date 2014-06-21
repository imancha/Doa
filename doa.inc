<?php
	//	Koneksi Database
	function mysql_open(){
		$host = "localhost";
		$database = "Doa";
		$user = "root";
		$password = "root";
		$link = mysql_connect($host,$user,$password);
		mysql_select_db($database,$link);
		if(!$link)
			echo "Error : ".mysql_error();
		return $link;
	}

	//	Header
	function myHeader(){
		echo '<h1>Doa Sehari Hari<h1>';
	}
	
	//	Navigator
	function navigator(){

		echo '<ul>											
						<li><p style="background:#4D4D4D"></p></li>
						<li><p style="background:#4D4D4D; color:#FFFFFF;"><b>MENU</b></p></li>							
						<li><p style="background:#4D4D4D"></p></li>
						<li><a href="index.php">Beranda</a></li>
						<li><a href="index.php?action=bookmark">Penanda</a></li>
						<li><a href="index.php?action=help">Bantuan</a></li>
						<li><a href="index.php?action=about">Tentang</a></li>												
			  	</ul>';
	}
	
	//	Footer
	function footer(){
		echo 'Copyright &copy; 2014 - UNIKOM';
	}

	mysql_open();

	$action = $_GET['action'];

	if($action == "doa"){
		$id = $_GET['id'];
				
		if($id > 0){
			$sql = "SELECT * FROM doa WHERE id='$id' LIMIT 1";
			$res = mysql_query($sql) or die(mysql_error());

			if(mysql_num_rows($res) == 1){
				$row = mysql_fetch_array($res);
				$id = $row['id'];
				$title = $row['nama'];
				$arab = $row['arab'];
				$terjemah = $row['terjemah'];

				$button = '<form action="" method="POST">
										<button name="mark" title="Tambah ke Penanda"">
											<img src="src/icon2.png" width="18px">
									 	</button>
									 </form>';

				if(isset($_POST['mark'])){
					$sql = "SELECT id FROM bookmark WHERE id='$id' LIMIT 1";
					$res = mysql_query($sql) or die(mysql_error());

					if(mysql_num_rows($res) == 0){
						$sql = "INSERT INTO bookmark VALUES('$id','$title','$arab','$terjemah',now())";
						$res = mysql_query($sql) or die(mysql_error());

						if($res)
							$content = '<div class="callout callout-info"><b>'.$title.'</b> berhasil ditambahkan ke <b>Penanda</b>.</div>';
						else
							$content = '<div class="callout callout-danger"><b>'.$title.'</b> gagal ditambahkan ke <b>Penanda</b>.</div>';
					}else{
						$content = '<div class="callout callout-info"><b>'.$title.'</b> berhasil ditambahkan ke <b>Penanda</b>.</div>';
					}
				}

				$prev = $id-1;
				
				if($prev > 0)
					$prev = "<button title='Doa Sebelumnya' onclick=\"window.location='index.php?action=doa&id=$prev'\"><< Sebelumnya</button>";
				else
					$prev = "";

				$sql = "SELECT max(id) FROM doa";
				$res = mysql_query($sql) or die(mysql_error());

				if(mysql_num_rows($res) == 1){
					$row = mysql_fetch_array($res);

					$next = $id+1;

					if($next > $row['0'])
						$next = "";
					else
						$next = "<button title='Doa Selanjutnya' onclick=\"window.location='index.php?action=doa&id=$next'\">Selanjutnya >></button>";
				}

				$audio = '<div class="audio">
										<audio controls>
											<source src="src/27 - One Piece Eyecatch Ongaku Nami.mp3" type="audio/mpeg">
											<p>Web Browser Anda tidak mendukung untuk memutar audio.</p>
										</audio>										 
									</div>';

				$nav = '<div style="float:left">'.$prev.'</div>
								<div style="float:right">'.$next.'</div>';

				$content .= '<div class="arabic">
											<h1>بسم الله الرحمن الرحيم</h1>
											<p>'.$arab.'</p>
										 </div>
										 <div class="latin">
											<p><i>"'.$terjemah.'"</i></p>
										 </div>
										 ';
			}		
		}		
	}else if($action == "bookmark"){
		$title = "Penanda";
		
		$content = '<form action="" method="POST">
									<input type="text" name="keyword" placeholder="Cari">
									<button name="search" title="Cari"><img src="src/magnifier.png" width="15px"></button>
								</form>';
		
		if(isset($_POST['delete'])){			
			$sql = "DELETE FROM bookmark WHERE id='".$_POST['id']."' LIMIT 1";
			$res = mysql_query($sql) or die(mysql_error());

			if($res)
				$content .= '<div class="callout callout-info"><b>'.$_POST['nama'].'</b> berhasil dihapus dari <b>Penanda</b>.</div>';
			else
				$content .= '<div class="callout callout-danger"><b>'.$_POST['nama'].'</b> gagal dihapus dari <b>Penanda</b>.</div>';			
		}

		$sql = "SELECT * FROM bookmark";

		if(isset($_POST['search']))
			$sql .= " WHERE nama like '%".$_POST['keyword']."%'";		

		$sql .= " ORDER BY date DESC";

		$res = mysql_query($sql) or die(mysql_error());

		if(mysql_num_rows($res) > 0){			
			$content .= "<ul>";			

			while($row = mysql_fetch_array($res)){
				$i = $row['id'];
				$nama = $row['nama'];

				$content .= '<li class="respons">
											<div style="float:left; width:94.4%; ">
												<a href="index.php?action=doa&id='.$i.'">'.$nama.'</a>
											</div>
											<div style="float:right;">
												<form action="" method="POST">
													<input type="hidden" name="id" value='.$i.'>
													<input type="hidden" name="nama" value="'.$nama.'">
													<button name="delete" title="Hapus dari Penanda" style="padding:8.8px; box-shadow: inset 0px 0px 0px 0px rgba(0, 0, 0, 0.09);"><b>&times;</b></button>
												</form>
											</div>
										</li>';
			}			

			$content .= "</ul>";			
		}else{
			$content .= "<div class='callout callout-danger'>Doa tidak ditemukan.</div>";
		}
	}else if($action == "help"){
		$title = "Bantuan";
		$content = '<div class="callout callout-warning">Silahkan gunakan Menu disamping untuk menggunakan aplikasi ini.</div>
								<div class="callout callout-warning">
									<b>Beranda</b> : berisi daftar doa sehari-hari yang bisa untuk dibaca.
									<p><b>Penanda</b> : berisi daftar doa yang sudah ditandai.</p>
									<p><b>Bantuan</b> : berisi tutorial atau cara menggunakan aplikasi ini.</p>	
									<p><b>Tentang</b> : berisi informasi mengenai aplikasi Doa Sehari Hari.</p>				
									<button title="Tambah ke Penanda" style="padding:0"><img src="src/icon2.png" width="18px"></button>
									: menambahkan doa yang sedang dibaca ke dalam Menu <b>Penanda</b>.
								</div>
								<div class="callout callout-warning">Untuk mempermudah dalam mencari doa yang ingin dibaca, silahkan gunakan fasilitas pencarian yang ada diatas daftar doa sehari-hari.</div>';
	}else if($action == "about"){
		$title = "Tentang";
		$content = '<div style="text-align:center">
									<h2>Doa Sehari-Hari<br><span style="font-size:12px; font-weight:normal; color:#7F7F7F;">( Versi Alpha )</span></h2>
									<p style="padding:40px"><img src="src/camera-loader.gif" width="60px"></p>
									<p><b>Dibuat Oleh:</b></p>										
									Salman Wahyudin<br>
									Wihardodo<br>
									Mohammad Febri Ramadlan<br>
									Mohammad Abdul Iman Syah		
								</div>';
	}else{
		$title = "Beranda";
		
		$content = '<form action="" method="POST">
										<input type="text" name="keyword" placeholder="Cari">
										<button name="search" title="Cari"><img src="src/magnifier.png" width="15px"></button>
									</form>';

		$sql = "SELECT * FROM doa";

		if(isset($_POST['search'])){			
			$sql .= " WHERE nama like '%".$_POST['keyword']."%'";
		}

		$res = mysql_query($sql) or die(mysql_error());

		if(mysql_num_rows($res) > 0){
			if(isset($_POST['search']))
				$content .= '<br><div class="callout callout-info">Data ditemukan sebanyak '.mysql_num_rows($res).' record.</div>';

			$content .= "<ul>";

			while($row = mysql_fetch_array($res)){
				$content .= '<li><a href="index.php?action=doa&id='.$row['id'].'">'.$row['nama'].'</a></li>';
			}

			$content .= "</ul>";
		}else{
			$content = "<div class='callout callout-danger'>Doa tidak ditemukan.</div>";
		}		
	}	
	mysql_close();
?>

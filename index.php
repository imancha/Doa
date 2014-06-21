<?php include_once("doa.inc");	?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="doa.css" type="text/css">
<title><?php echo $title; ?></title>
</head>

<body>
<div class="container">
	<div class="header"><?php myHeader(); ?></div>	
	<div class="content">
		<div class="left navigator"><?php navigator(); ?></div>
		<div class="main">
			<div class="box">
				<div class="box-header">
					<div class="box-title">
						<?php echo $title; ?>
						<span style="float:right">
							<?php echo $button; ?>
						</span>
					</div>
				</div>
				<div class="box-body">
					<div class="row-content">
						<?php echo $content; ?>
					</div>
					<div class="row-audio">
						<?php echo $audio; ?>
					</div>
				</div>			
				<div class="box-footer"><?php echo $nav; ?></div>	
			</div>
		</div>		
	</div>
	<div class="footer"><?php footer(); ?></div>
</div>
</body>
</html>

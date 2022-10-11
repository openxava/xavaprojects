Version 2022-10
----------------
SET foreign_key_checks = 0;
update xavaprojects.oxmodules
set application = 'xavaprojects';
update xavaprojects.oxroles_oxmodules
set modules_application = 'xavaprojects';
SET foreign_key_checks = 1;

Repeat for each organization

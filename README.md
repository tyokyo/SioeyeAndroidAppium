"# SioeyeAndroidAppium" 
步骤一:启动对应的appium-server
node /Applications/Appium.app/Contents/Resources/app/node_modules/appium  -p 4723 -a 10.120.3.115 -U HC44VWM04926  --command-timeout 600   --no-reset --session-override
node /Applications/Appium.app/Contents/Resources/app/node_modules/appium  -p 4724 -a 10.120.3.115 -U 8575493232375833  --command-timeout 600   --no-reset --session-override
node /Applications/Appium.app/Contents/Resources/app/node_modules/appium  -p 4725 -a 10.120.3.115 -U C4Y7N16328001270  --command-timeout 600   --no-reset --session-override
node /Applications/Appium.app/Contents/Resources/app/node_modules/appium  -p 4726 -a 10.120.3.115 -U 7254b451  --command-timeout 600   --no-reset --session-override
启动ip地址为自己虚拟机的地址

步骤二：修改testng.xml
修改ip port udid 

步骤三：执行次数
修改config.properties 的runtime
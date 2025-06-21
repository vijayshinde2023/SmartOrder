@echo off
for %%D in (
    discovery-server 
    config-server 
    api-gateway 
    auth-service 
    user-service 
    order-service 
    inventory-service
) do (
    echo Building %%D...
    cd %%D
    call mvn clean install -DskipTests
    cd ..
)
pause

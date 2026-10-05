Function multiplayer_hostserver%(arg0$, arg1%, arg2$, arg3%, arg4%, arg5#, arg6%, arg7%, arg8%, arg9%, arg10$)
    ipnet = "localhost"
    portnet = (Str arg1)
    If (portnet = "4379") Then
        portnet = (Str rand($C382, $DAC0))
    EndIf
    passwordmenu = $00
    connectmenu = $00
    udp_setstream(udp_network, $00, $00, $00, $01)
    adderrorlog("Joining...", $FF, $FF, $FF, $1388)
    If (udp_setstream(udp_network, createudpstream("0", (Int portnet)), $00, $00, $01) = $00) Then
        adderrorlog("Couldn't create server", $FF, $00, $00, $1388)
        mainmenutab = $01
        Return $00
    Else
        networkserver\Field32 = $01
        networkserver\Field1 = hostip(counthostips("127.0.0.1"))
        networkserver\Field2 = (Int portnet)
        networkserver\Field52\Field0 = arg0
        networkserver\Field20 = $01
        multiplayer_createplayer(networkserver\Field20)
        myplayer\Field27 = $00
        myplayer\Field28 = $00
        myplayer\Field49 = classd_model
        myplayer\Field48 = rand($01, $03)
        randomseed = arg2
        introenabled = arg3
        nocheat = arg7
        networkserver\Field52\Field10 = arg9
        networkserver\Field5 = (Float rand($00, $01))
        networkserver\Field3 = $15F90
        networkserver\Field52\Field15 = arg5
        networkserver\Field52\Field16 = arg6
        networkserver\Field52\Field12 = timekeepinventory
        networkserver\Field52\Field14 = arg8
        networkserver\Field15 = $01
        networkserver\Field52\Field1 = arg10
        networkserver\Field52\Field13 = $BB80
        networkserver\Field16 = arg4
        mainmenutab = $0E
        networkserver\Field21 = $01
        networkserver\Field22 = $01
        udp_writetimeout($00, multiplayer_gettickratedelay())
        udp_writetimeout($01, multiplayer_gettickratedelay())
        udp_writetimeout($02, $5DC)
        udp_writetimeout($03, $5DC)
        networkserver\Field36 = $01
        steam_createlobby(networkserver\Field38, networkserver\Field52\Field14)
    EndIf
    Return $00
End Function

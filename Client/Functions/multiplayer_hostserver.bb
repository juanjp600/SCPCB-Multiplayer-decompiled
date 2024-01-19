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
    If (udp_setstream(udp_network, createudpstream((Int portnet)), $00, $00, $01) = $00) Then
        adderrorlog("Couldn't create server", $FF, $00, $00, $1388)
        mainmenutab = $01
        Return $00
    Else
        networkserver\Field42 = $01
        networkserver\Field1 = hostip(counthostips("127.0.0.1"))
        networkserver\Field2 = (Int portnet)
        networkserver\Field21 = arg0
        networkserver\Field28 = $01
        multiplayer_createplayer(networkserver\Field28)
        myplayer\Field29 = $00
        myplayer\Field30 = $00
        myplayer\Field51 = classd_model
        myplayer\Field50 = rand($01, $03)
        randomseed = arg2
        introenabled = arg3
        nocheat = arg7
        networkserver\Field24 = arg9
        networkserver\Field5 = (Float rand($00, $01))
        networkserver\Field3 = $15F90
        networkserver\Field12 = arg5
        networkserver\Field13 = arg6
        networkserver\Field23 = timekeepinventory
        networkserver\Field14 = arg8
        networkserver\Field18 = $01
        networkserver\Field20 = arg10
        networkserver\Field30 = $BB80
        networkserver\Field19 = arg4
        networkserver\Field48 = $03
        mainmenutab = $0E
        networkserver\Field29 = $01
        networkserver\Field31 = $01
        udp_writetimeout($00, multiplayer_gettickratedelay())
        udp_writetimeout($01, multiplayer_gettickratedelay())
        udp_writetimeout($02, $5DC)
        udp_writetimeout($03, $5DC)
        networkserver\Field49 = $01
        bs_steammatchmaking_createlobby(bs_steammatchmaking(), networkserver\Field51, networkserver\Field14)
    EndIf
    Return $00
End Function

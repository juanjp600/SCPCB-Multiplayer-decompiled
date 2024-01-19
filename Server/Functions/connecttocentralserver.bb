Function connecttocentralserver%(arg0$, arg1%, arg2%)
    Local local0.centralserversegments
    Local local1%
    Return $00
    If (server\Field69 <> 0) Then
        If (centralserver\Field0 <> $00) Then
            closetcpstream(centralserver\Field0)
        EndIf
        addlog("Connecting to central server...", $00, $00, $01)
        If (arg0 = "") Then
            For local0 = Each centralserversegments
                arg0 = local0\Field0
                arg1 = local0\Field1
                centralserver\Field0 = getconnectiontocentralserver(arg0, arg1)
                If (centralserver\Field0 <> $00) Then
                    Exit
                EndIf
            Next
        Else
            centralserver\Field0 = getconnectiontocentralserver(arg0, arg1)
        EndIf
        If (centralserver\Field0 <> $00) Then
            addlog("Connected successfully!", $00, $00, $01)
            setcentralserver(arg0, arg1)
            Return $01
        Else
            addlog("Failed to connect to central server", $00, $00, $01)
            If (getscripts() <> 0) Then
                public_inqueue($44, $01)
            EndIf
            If (arg2 <> 0) Then
                For local0 = Each centralserversegments
                    arg0 = local0\Field0
                    arg1 = local0\Field1
                    Exit
                Next
                setcentralserver(arg0, arg1)
            EndIf
            Return $00
        EndIf
    Else
        steam_release = bs_steamgameserver_init($00, $00, $00, $00, $03, (Str local1))
        If (steam_release <> 0) Then
            bs_isteamgameserver_logonanonymous(bs_steamgameserver())
            bs_isteamgameserver_initgameserver(bs_steamgameserver(), $00, $00, $00, $03, $1B326C, "SCP:CB:Server")
            addlog("SteamGameServer successfully started.", $00, $00, $01)
        Else
            addlog("SteamGameServer initing failed.", $00, $00, $01)
        EndIf
        Return steam_release
    EndIf
    Return $00
End Function

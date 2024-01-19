Function multiplayer_list_addserver.servers(arg0$, arg1%, arg2%, arg3%, arg4%)
    Local local0.servers
    If (arg3 = $00) Then
        If (serverinlist(arg0, arg1, arg2) <> 0) Then
            If (arg4 <> 0) Then
                adderrorlog("This server is already on the server list", $FF, $00, $00, $1388)
            EndIf
            Return getserverinlist(arg0, arg1, arg2)
        EndIf
    EndIf
    local0 = (New servers)
    local0\Field1 = arg0
    local0\Field2 = (Str arg1)
    local0\Field10 = ((arg0 + ":") + (Str arg1))
    local0\Field4 = $00
    local0\Field5 = "-"
    local0\Field6 = "0 / 0"
    local0\Field9 = "Offline"
    local0\Field0 = arg2
    addservermenu = $00
    multiplayer_list_updateserver(local0, $1388, $01)
    Return local0
    Return Null
End Function

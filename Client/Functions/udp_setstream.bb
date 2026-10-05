Function udp_setstream%(arg0.udp_net, arg1%, arg2%, arg3%, arg4%)
    If (arg1 = $00) Then
        If (networkserver\Field37 <> $00) Then
            steam_leavelobby()
        EndIf
        networkserver\Field36 = $00
        networkserver\Field37 = $00
        getsteamticket()
        If (arg0\Field0 <> $00) Then
            closeudpstream(arg0\Field0)
            arg0\Field0 = $00
            arg0\Field4 = 0.0
            arg0\Field5 = 0.0
            arg0\Field7 = $00
            Return $01
        Else
            Return $00
        EndIf
    EndIf
    arg0\Field0 = arg1
    If (arg2 = $00) Then
        arg0\Field12 = hostip(counthostips("127.0.0.1"))
        arg0\Field3 = udpstreamport(arg0\Field0)
        arg0\Field1 = hostip(counthostips("127.0.0.1"))
        arg0\Field2 = udpstreamport(arg0\Field0)
        If (((udpstreamport(arg0\Field0) < $50) Or (udpstreamport(arg0\Field0) > $FFFE)) <> 0) Then
            closeudpstream(arg0\Field0)
            arg0\Field0 = createudpstream("0", $00)
            arg0\Field2 = udpstreamport(arg0\Field0)
        EndIf
    Else
        arg0\Field1 = arg2
        arg0\Field2 = arg3
        arg0\Field12 = hostip(counthostips("127.0.0.1"))
        arg0\Field3 = udpstreamport(arg1)
    EndIf
    Return $01
    Return $00
End Function

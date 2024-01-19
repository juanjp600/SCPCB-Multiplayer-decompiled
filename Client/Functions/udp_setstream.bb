Function udp_setstream%(arg0.udp_net, arg1%, arg2%, arg3%, arg4%)
    If (arg1 = $00) Then
        If (arg0\Field0 <> $00) Then
            closeudpstream(arg0\Field0)
            If (networkserver\Field50 <> $00) Then
                bs_steammatchmaking_leavelobby(bs_steammatchmaking(), networkserver\Field50)
            EndIf
            If (((networkserver\Field42 = $00) And networkserver\Field49) <> 0) Then
                If (arg0\Field7 <> $00) Then
                    bs_isteamnetworking_closep2psessionwithuser(bs_steamnetworking(), udp_fillsteam(bs_csteamid_getaccountid(arg0\Field7)))
                EndIf
            EndIf
            arg0\Field0 = $00
            arg0\Field4 = 0.0
            arg0\Field5 = 0.0
            arg0\Field7 = $00
            networkserver\Field49 = $00
            networkserver\Field50 = $00
            cancelsteamticket()
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
            arg0\Field0 = createudpstream($00)
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

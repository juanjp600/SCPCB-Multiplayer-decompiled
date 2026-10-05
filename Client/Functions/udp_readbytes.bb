Function udp_readbytes%(arg0%, arg1%, arg2%)
    If (networkserver\Field36 <> 0) Then
        steam_pullbytes(arg0, arg1, arg2)
        Return $00
    EndIf
    Return readbytes(arg0, udp_network\Field0, arg1, arg2)
    Return $00
End Function

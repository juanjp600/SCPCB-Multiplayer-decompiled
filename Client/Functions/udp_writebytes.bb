Function udp_writebytes%(arg0%, arg1%, arg2%)
    If (networkserver\Field36 <> 0) Then
        steam_pushbytes(arg0, arg1, arg2)
    Else
        writebytes(arg0, udp_network\Field0, arg1, arg2)
    EndIf
    Return $00
End Function

Function udp_writebyte%(arg0%)
    If (networkserver\Field36 <> 0) Then
        steam_pushbyte(arg0)
        Return $00
    EndIf
    writebyte(udp_network\Field0, arg0)
    Return $00
End Function

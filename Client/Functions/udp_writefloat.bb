Function udp_writefloat%(arg0#)
    If (networkserver\Field36 <> 0) Then
        steam_pushfloat(arg0)
        Return $00
    EndIf
    writefloat(udp_network\Field0, arg0)
    Return $00
End Function

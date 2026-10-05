Function udp_writeint%(arg0%)
    If (networkserver\Field36 <> 0) Then
        steam_pushint(arg0)
        Return $00
    EndIf
    writeint(udp_network\Field0, arg0)
    Return $00
End Function

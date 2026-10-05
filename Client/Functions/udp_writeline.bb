Function udp_writeline%(arg0$)
    If (networkserver\Field36 <> 0) Then
        steam_pushstring(arg0)
        Return $00
    EndIf
    writeline(udp_network\Field0, arg0)
    Return $00
End Function

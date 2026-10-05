Function udp_writeshort%(arg0%)
    If (networkserver\Field36 <> 0) Then
        steam_pushshort(arg0)
        Return $00
    EndIf
    writeshort(udp_network\Field0, arg0)
    Return $00
End Function

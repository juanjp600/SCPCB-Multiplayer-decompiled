Function udp_readline$()
    If (networkserver\Field36 <> 0) Then
        Return steam_pullstring()
    EndIf
    Return readline(udp_network\Field0)
    Return ""
End Function

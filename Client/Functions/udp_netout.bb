Function udp_netout%(arg0%)
    If (millisecs() > udp_network\Field10[arg0]) Then
        udp_netin(arg0)
        Return $01
    EndIf
    Return $00
    Return $00
End Function

Function multiplayer_doineedtoleave%()
    Local local0$
    Local local1%
    If (shouldkick <> "") Then
        disconnectserver("", $01)
        adderrorlog(shouldkick, $FF, $00, $00, $61A8)
        shouldkick = ""
    EndIf
    If (shouldrestartserver <> 0) Then
        local0 = dottedip(udp_network\Field7)
        local1 = udp_network\Field8
        disconnectserver("Restarting", $01)
        restartingserver(local0, local1)
        shouldrestartserver = $00
    Else
        shouldrestartserver = $00
    EndIf
    Return $00
End Function

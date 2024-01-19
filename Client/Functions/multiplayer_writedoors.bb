Function multiplayer_writedoors%(arg0%)
    Local local0.doors
    For local0 = Each doors
        If (((hidedistance > entitydistance(local0\Field0, player[arg0]\Field13)) And (local0\Field23 = $00)) <> 0) Then
            udp_writeshort(local0\Field18)
            udp_writebyte((local0\Field5 + (local0\Field4 Shl $01)))
        EndIf
    Next
    udp_writeshort($00)
    Return $00
End Function

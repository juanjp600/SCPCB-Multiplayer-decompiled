Function movetopocketdimension%(arg0%)
    Local local0%
    Local local1.events
    For local1 = Each events
        If (local1\Field22 = $02) Then
            positionentity(player[arg0]\Field62, entityx(local1\Field1\Field2, $00), 1.0, entityz(local1\Field1\Field2, $00), $00)
            player[arg0]\Field86 = 0.0
            resetentity(player[arg0]\Field62)
            If (server\Field21 = $00) Then
                giveplayerhealth(arg0, -20.0, "was killed by SCP-106")
            EndIf
            mp_setplayerroomid(player[arg0], local1\Field1)
            mp_updateplayerposition(player[arg0], $01)
            setplayerposition(arg0, room[player[arg0]\Field32]\Field7\Field10, entityx(player[arg0]\Field62, $00), (entityy(player[arg0]\Field62, $00) + 0.1), entityz(player[arg0]\Field62, $00))
            Return $00
        EndIf
    Next
    Return $00
End Function

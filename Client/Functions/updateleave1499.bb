Function updateleave1499%()
    Local local0.rooms
    Local local1.items
    Local local2.rooms
    Local local3.rooms
    Local local4%
    Local local5#
    Local local6#
    If (((i_1499\Field0 = $00) And (playerroom\Field7\Field6 = $6A)) <> 0) Then
        For local0 = Each rooms
            If (local0 = i_1499\Field4) Then
                isblackout = previsblackout
                previsblackout = $01
                me\Field10 = -10.0
                i_1499\Field5 = entityx(me\Field60, $00)
                i_1499\Field6 = entityy(me\Field60, $00)
                i_1499\Field7 = entityz(me\Field60, $00)
                teleportentity(me\Field60, i_1499\Field1, (i_1499\Field2 + 0.05), i_1499\Field3, 0.3, $00, 2.0, $00)
                teleporttoroom(local0)
                If (((i_1499\Field4\Field7\Field6 = $1F) And (infacility = $FFFFFFFF)) <> 0) Then
                    For local4 = $00 To $03 Step $01
                        playerroom\Field15[local4]\Field10 = 2.0
                        positionentity(playerroom\Field15[local4]\Field3, entityx(playerroom\Field11[(Int playerroom\Field15[local4]\Field11)], $01), (entityy(playerroom\Field11[(Int playerroom\Field15[local4]\Field11)], $01) + 0.2), entityz(playerroom\Field11[(Int playerroom\Field15[local4]\Field11)], $01), $00)
                        resetentity(playerroom\Field15[local4]\Field3)
                        playerroom\Field15[local4]\Field11 = (playerroom\Field15[local4]\Field11 + 1.0)
                        If ((Float playerroom\Field15[local4]\Field13) < playerroom\Field15[local4]\Field11) Then
                            playerroom\Field15[local4]\Field11 = (Float (playerroom\Field15[local4]\Field13 - $03))
                        EndIf
                    Next
                EndIf
                For local2 = Each rooms
                    If (local2\Field7\Field6 = $6A) Then
                        local3 = local2
                        Exit
                    EndIf
                Next
                For local1 = Each items
                    If (((local1\Field4\Field2 = $24) Lor (local1\Field4\Field2 = $25)) <> 0) Then
                        local5 = entityy(local1\Field2, $00)
                        local6 = entityy(local3\Field2, $00)
                        If (local5 >= (local6 - 5.0)) Then
                            positionentity(local1\Field2, i_1499\Field1, (i_1499\Field2 + (local5 - local6)), i_1499\Field3, $00)
                            resetentity(local1\Field2)
                            Exit
                        EndIf
                    EndIf
                Next
                local3 = Null
                fog\Field0 = (6.0 - (2.0 * (Float isblackout)))
                clearfogcolor()
                playsound_strict(loadtempsound("SFX\SCP\1499\Exit.ogg"), $00, $01)
                i_1499\Field1 = 0.0
                i_1499\Field2 = 0.0
                i_1499\Field3 = 0.0
                i_1499\Field4 = Null
                Exit
            EndIf
        Next
    EndIf
    Return $00
End Function

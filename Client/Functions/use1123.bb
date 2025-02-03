Function use1123%()
    Local local0.events
    Local local1%
    If ((((i_714\Field0 <> $02) And (wi\Field0 <> $04)) And (wi\Field2 <> $04)) <> 0) Then
        me\Field51 = 3.0
        playsound_strict(loadtempsound("SFX\SCP\1123\Touch.ogg"), $00, $01)
        local1 = $01
        For local0 = Each events
            If (local0\Field0 = $10) Then
                If (playerroom = local0\Field1) Then
                    If (1.0 > local0\Field2) Then
                        local0\Field2 = 1.0
                        local1 = $00
                        Exit
                    EndIf
                EndIf
            EndIf
        Next
    Else
        createmsg(getlocalstring("msg", "skull.nothappend"), 6.0)
    EndIf
    If (local1 <> 0) Then
        msg\Field2 = format(getlocalstring("death", "1123"), subjectname, "%s")
        kill($00, $01, $00, $01)
    EndIf
    Return $00
End Function

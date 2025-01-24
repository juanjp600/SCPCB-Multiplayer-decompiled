Function playstepsound%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local6#
    local0 = getstepsound(me\Field60)
    If (decalstep = $01) Then
        local0 = $02
    ElseIf (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
        If (1.0 = forest_event\Field2) Then
            local0 = $04
        EndIf
    EndIf
    local1 = $00
    local2 = $00
    local3 = $01
    local4 = rand($00, $07)
    Select local0
        Case $02,$03,$04
            local3 = $00
            local4 = rand($00, $02)
        Case $05
            local3 = $00
            local4 = rand($00, $01)
    End Select
    local1 = playsound_strict(stepsfx(local0, (arg0 And local3), local4), $00)
    local6 = (((1.0 - ((Float me\Field39) * 0.7)) * opt\Field20) * opt\Field16)
    channelvolume(local1, local6)
    If (((decalstep = $02) And (local0 <> $05)) <> 0) Then
        local2 = playsound_strict(stepsfx($05, $00, rand($00, $01)), $00)
        channelvolume(local2, local6)
    EndIf
    me\Field42 = max(((4.0 * (Float arg0)) + ((2.5 - ((Float me\Field39) * 0.7)) * (Float ($01 - arg0)))), me\Field42)
    Return $00
End Function

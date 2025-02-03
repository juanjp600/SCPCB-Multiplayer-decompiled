Function setcrouch%(arg0%)
    Local local0%
    If (arg0 <> me\Field39) Then
        playsound_strict(snd_i\Field23, $00, $01)
        me\Field42 = max(2.0, me\Field42)
        If (((arg0 = $00) And (0.0 < me\Field17)) <> 0) Then
            me\Field17 = (me\Field17 - rnd(8.0, 16.0))
            If (10.0 > me\Field17) Then
                If (channelplaying(breathchn) = $00) Then
                    local0 = $00
                    If ((((wi\Field0 > $00) Lor (i_1499\Field0 > $00)) Lor (wi\Field2 > $00)) <> 0) Then
                        local0 = $01
                    EndIf
                    breathchn = playsound_strict(breathsfx(local0, $00), $01, $01)
                EndIf
            EndIf
        EndIf
        me\Field39 = arg0
    EndIf
    Return $00
End Function

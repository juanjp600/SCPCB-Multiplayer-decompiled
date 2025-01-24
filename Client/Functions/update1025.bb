Function update1025%()
    Local local0%
    Local local3%
    For local0 = $00 To $06 Step $01
        If (0.0 < i_1025\Field0[local0]) Then
            Select local0
                Case $00
                    updatecough($3E8)
                    me\Field17 = (me\Field17 - (fps\Field7[$00] * 0.2))
                Case $01
                    If (rand($2328, $01) = $01) Then
                        createmsg(getlocalstring("msg", "skinitchy"), 6.0)
                    EndIf
                Case $02
                    updatecough($320)
                    If (((0.0 < me\Field38) And keydown(key\Field7)) <> 0) Then
                        me\Field17 = (me\Field17 - (fps\Field7[$00] * 0.3))
                    EndIf
                Case $03
                    If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
                        i_1025\Field0[local0] = (i_1025\Field0[local0] + (fps\Field7[$00] * 0.0005))
                    EndIf
                    If (20.0 < i_1025\Field0[local0]) Then
                        If (20.0 >= (i_1025\Field0[local0] - fps\Field7[$00])) Then
                            createmsg(getlocalstring("msg", "stomachunbearable"), 6.0)
                        EndIf
                        me\Field17 = (me\Field17 - (fps\Field7[$00] * 0.3))
                    ElseIf (10.0 < i_1025\Field0[local0]) Then
                        If (10.0 >= (i_1025\Field0[local0] - fps\Field7[$00])) Then
                            createmsg(getlocalstring("msg", "stomachaching"), 6.0)
                        EndIf
                    EndIf
                Case $04
                    If (35.0 > me\Field17) Then
                        updatecough((Int ((me\Field17 * 8.0) + 140.0)))
                        me\Field38 = curvevalue(0.0, me\Field38, ((me\Field17 * 15.0) + 10.0))
                    EndIf
                Case $05
                    If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
                        i_1025\Field0[local0] = (i_1025\Field0[local0] + (fps\Field7[$00] * 0.35))
                    EndIf
                    If (110.0 < i_1025\Field0[local0]) Then
                        me\Field28 = 0.0
                        me\Field49 = max(me\Field49, 500.0)
                        If (140.0 < i_1025\Field0[local0]) Then
                            msg\Field2 = getlocalstring("death", "1025")
                            kill($00, $01, $00, $01)
                        EndIf
                    Else
                        me\Field28 = max(me\Field28, (i_1025\Field0[local0] + 70.0))
                        me\Field30 = 1.0
                    EndIf
                Case $06
                    If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
                        i_1025\Field0[local0] = (i_1025\Field0[local0] + (fps\Field7[$00] / 70.0))
                    EndIf
                    If (75.0 > i_1025\Field0[local0]) Then
                        If (((15.0 < i_1025\Field0[local0]) And (i_714\Field0 = $00)) <> 0) Then
                            me\Field17 = min(100.0, ((((100.0 - me\Field17) * ((i_1025\Field0[local0] / 17500.0) + 0.001)) * fps\Field7[$00]) + me\Field17))
                        EndIf
                    Else
                        me\Field18 = max(me\Field18, 1.2)
                        me\Field19 = 14.0
                    EndIf
                    If (100.0 < i_1025\Field0[local0]) Then
                        i_1025\Field0[local0] = 1.0
                    EndIf
                    If (((15.0 < i_1025\Field0[local0]) And (15.0 >= (i_1025\Field0[local0] - fps\Field7[$00]))) <> 0) Then
                        createmsg(getlocalstring("msg", "energetic"), 6.0)
                    EndIf
            End Select
        EndIf
    Next
    For local0 = $01 To $02 Step $01
        If (0.0 < i_1025\Field1[local0]) Then
            Select local0
                Case $01
                    If (((i_427\Field0 = $00) And (25200.0 > i_427\Field1)) <> 0) Then
                        local3 = (Int ((Float rand($28, $32)) * 70.0))
                        If (15.0 < i_1025\Field1[local0]) Then
                            i_1025\Field1[local0] = (i_1025\Field1[local0] + fps\Field7[$00])
                            If ((Float local3) < i_1025\Field1[local0]) Then
                                i_1025\Field1[local0] = 1.0
                            EndIf
                        ElseIf (rand($28, $01) = $01) Then
                            i_1025\Field1[local0] = (i_1025\Field1[local0] + 1.0)
                            Select rand($08, $01)
                                Case $01,$02,$03,$05
                                    me\Field10 = -10.0
                                Case $04,$05,$06
                                    me\Field23 = rnd(0.5, 2.0)
                                Case $07,$08
                                    playsound_strict(loadtempsound((("SFX\SCP\294\Retch" + (Str rand($00, $01))) + ".ogg")), $00)
                                    me\Field42 = max(4.0, me\Field42)
                            End Select
                        EndIf
                    EndIf
                Case $02
                    If (i_714\Field0 = $00) Then
                        me\Field20 = 50.0
                        me\Field17 = curvevalue(min(me\Field20, me\Field17), me\Field17, 20.0)
                    EndIf
                    If (25.0 > me\Field17) Then
                        me\Field5 = curvevalue(-450.0, me\Field5, 15.0)
                    EndIf
            End Select
        EndIf
    Next
    Return $00
End Function

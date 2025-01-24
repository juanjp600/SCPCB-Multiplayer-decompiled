Function mp_updatenpctyped_clerk%(arg0.npcs)
    Local local0#
    If (arg0\Field50 = $00) Then
        local0 = arg0\Field14
        rotateentity(arg0\Field3, 0.0, entityyaw(arg0\Field3, $00), entityroll(arg0\Field3, $00), $01)
        Select arg0\Field10
            Case -1.0
            Case 0.0
                arg0\Field24 = curvevalue(0.0, arg0\Field24, 5.0)
                animatenpc(arg0, 210.0, 235.0, 0.1, $01)
            Case 1.0
                arg0\Field24 = curvevalue((arg0\Field23 * 0.7), arg0\Field24, 20.0)
                animatenpc(arg0, 236.0, 260.0, (arg0\Field24 * 18.0), $01)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                If (0.005 < arg0\Field24) Then
                    If ((((244.0 > local0) And (244.0 <= arg0\Field14)) Lor ((254.0 > local0) And (254.0 <= arg0\Field14))) <> 0) Then
                        playsoundex(stepsfx(getstepsound(arg0\Field3), $00, rand($00, $02)), camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00)
                    EndIf
                ElseIf (-0.005 > arg0\Field24) Then
                    If ((((254.0 <= local0) And (254.0 > arg0\Field14)) Lor ((244.0 <= local0) And (244.0 > arg0\Field14))) <> 0) Then
                        playsoundex(stepsfx(getstepsound(arg0\Field3), $00, rand($00, $02)), camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00)
                    EndIf
                EndIf
            Case 2.0
                arg0\Field24 = curvevalue(arg0\Field23, arg0\Field24, 5.0)
                animatenpc(arg0, 301.0, 319.0, (arg0\Field24 * 18.0), $01)
                moveentity(arg0\Field3, 0.0, 0.0, (arg0\Field24 * fps\Field7[$00]))
                If (0.005 < arg0\Field24) Then
                    If ((((309.0 > local0) And (309.0 <= arg0\Field14)) Lor ((319.0 >= local0) And (301.0 >= arg0\Field14))) <> 0) Then
                        playsoundex(stepsfx(getstepsound(arg0\Field3), $01, rand($00, $02)), camera, arg0\Field3, 8.0, rnd(0.3, 0.5), $00)
                    EndIf
                EndIf
        End Select
        If (((arg0\Field60 <= $00) And (arg0\Field4 = $12)) <> 0) Then
            setnpcframe(arg0, 41.0)
            arg0\Field50 = $01
        EndIf
    Else
        Select arg0\Field12
            Case -1.0
            Case 0.0
                animatenpc(arg0, 1.0, 40.0, 0.5, $00)
            Case 1.0
                animatenpc(arg0, 41.0, 60.0, 0.5, $00)
            Case 2.0
                animatenpc(arg0, 555.0, 629.0, 0.5, $00)
            Case 3.0
                animatenpc(arg0, 630.0, 677.0, 0.5, $00)
            Case 4.0
                animatenpc(arg0, 678.0, 711.0, 0.5, $00)
            Case 5.0
                animatenpc(arg0, 712.0, 779.0, 0.5, $00)
        End Select
    EndIf
    positionentity(arg0\Field0, entityx(arg0\Field3, $00), (entityy(arg0\Field3, $00) - 0.2), entityz(arg0\Field3, $00), $00)
    rotateentity(arg0\Field0, entitypitch(arg0\Field3, $00), (entityyaw(arg0\Field3, $00) - 180.0), 0.0, $00)
    Return $00
End Function

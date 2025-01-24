Function mp_dropplayeritem%(arg0.mp_player, arg1.items)
    Local local0%
    Local local1%
    If (arg1\Field27 = arg0\Field5) Then
        arg0\Field3 = (arg0\Field3 - $01)
        For local0 = $00 To (arg1\Field20 - $01) Step $01
            If (arg1\Field18[local0] <> Null) Then
                arg1\Field18[local0]\Field27 = $00
            EndIf
        Next
        arg1\Field16 = $01
        arg1\Field27 = $00
        arg1\Field15 = $00
        arg1\Field24 = $00
        local1 = rndseed()
        seedrnd((arg0\Field5 + generateseednumber(arg0\Field6)))
        positionentity(arg1\Field2, entityx(arg0\Field18, $00), ((entityy(arg0\Field18, $00) + 0.6) + ((Float arg0\Field27) * -0.3)), entityz(arg0\Field18, $00), $00)
        showentity(arg1\Field2)
        rotateentity(arg1\Field2, arg0\Field10, (arg0\Field11 + rnd(-20.0, 20.0)), 0.0, $00)
        moveentity(arg1\Field2, 0.0, -0.1, 0.1)
        rotateentity(arg1\Field2, 0.0, (arg0\Field11 + rnd(-110.0, 110.0)), 0.0, $00)
        resetentity(arg1\Field2)
        seedrnd(local1)
        Select arg1\Field4\Field2
            Case $3C,$3D,$3E,$3F
                setanimtime(arg1\Field3, 4.0, $00)
        End Select
        If (arg0\Field26 = arg1\Field19) Then
            arg0\Field26 = $00
        EndIf
    EndIf
    Return $00
End Function

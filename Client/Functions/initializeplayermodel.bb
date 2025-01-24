Function initializeplayermodel%(arg0.mp_player)
    Local local0%
    Local local1%
    Local local2%
    If ((((arg0\Field5 <> mp_getmyindex()) And (arg0\Field35\Field0 = $00)) And (arg0\Field35\Field17 > $00)) <> 0) Then
        arg0\Field35\Field1 = getplayermodelmeshpreset(arg0\Field35\Field17)
        arg0\Field35\Field0 = copyentity(getplayermodelmesh(arg0\Field35\Field17), $00)
        entitytexture(arg0\Field35\Field0, getplayermodeltexture(arg0\Field35\Field18), $00, $00)
        entityparent(arg0\Field35\Field0, arg0\Field18, $01)
        rotateentity(arg0\Field35\Field0, 0.0, arg0\Field35\Field1\Field8, 0.0, $00)
        positionentity(arg0\Field35\Field0, 0.0, arg0\Field35\Field1\Field9, 0.0, $00)
        scaleentity(arg0\Field35\Field0, arg0\Field35\Field20, arg0\Field35\Field20, arg0\Field35\Field20, $01)
        entityradius(arg0\Field18, (arg0\Field35\Field19 / 2.0), arg0\Field35\Field19)
        showentity(arg0\Field18)
        arg0\Field35\Field2 = findchild(arg0\Field35\Field0, arg0\Field35\Field1\Field1)
        arg0\Field35\Field3 = findchild(arg0\Field35\Field0, arg0\Field35\Field1\Field0)
        arg0\Field35\Field4 = findchild(arg0\Field35\Field0, arg0\Field35\Field1\Field2)
        arg0\Field35\Field5 = findchild(arg0\Field35\Field0, arg0\Field35\Field1\Field3)
        For local0 = $01 To $13 Step $01
            local1 = $00
            local2 = $00
            If (arg0\Field35\Field1\Field22[local0] <> $00) Then
                local1 = getfirstpackedvalue(arg0\Field35\Field1\Field22[local0])
                local2 = getsecondpackedvalue(arg0\Field35\Field1\Field22[local0])
            EndIf
            extractanimseq(arg0\Field35\Field0, local1, local2, $00)
        Next
        arg0\Field14 = $01
        animate(arg0\Field35\Field0, $01, arg0\Field35\Field1\Field23[arg0\Field14], arg0\Field14, 0.0)
        If (arg0\Field35\Field1\Field7 <> 0) Then
            If (arg0\Field35\Field3 <> $00) Then
                arg0\Field35\Field8 = entityroll(arg0\Field35\Field3, $01)
            EndIf
            If (arg0\Field35\Field2 <> $00) Then
                arg0\Field35\Field9 = entityroll(arg0\Field35\Field2, $01)
            EndIf
        EndIf
    EndIf
    Return $00
End Function

Function dropitem%(arg0.items, arg1%)
    Local local0%
    Local local1#
    Local local2%
    Local local3%
    catcherrors("DropItem()")
    local1 = entityyaw(camera, $00)
    If (((arg0\Field4\Field3 <> $42) And arg1) <> 0) Then
        playsound_strict(snd_i\Field44[arg0\Field4\Field3], $00)
    EndIf
    arg0\Field16 = $01
    showentity(arg0\Field2)
    If (mp_getsocket() = $00) Then
        positionentity(arg0\Field2, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        rotateentity(arg0\Field2, entitypitch(camera, $00), (rnd(-20.0, 20.0) + local1), 0.0, $00)
        moveentity(arg0\Field2, 0.0, -0.1, 0.1)
        rotateentity(arg0\Field2, 0.0, (rnd(-110.0, 110.0) + local1), 0.0, $00)
        resetentity(arg0\Field2)
    Else
        local2 = rndseed()
        seedrnd((mp_getmyindex() + generateseednumber(opt\Field46)))
        positionentity(arg0\Field2, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        rotateentity(arg0\Field2, entitypitch(camera, $00), (rnd(-20.0, 20.0) + local1), 0.0, $00)
        moveentity(arg0\Field2, 0.0, -0.1, 0.1)
        rotateentity(arg0\Field2, 0.0, (rnd(-110.0, 110.0) + local1), 0.0, $00)
        resetentity(arg0\Field2)
        seedrnd(local2)
    EndIf
    local3 = arg0\Field4\Field2
    Select arg0\Field4\Field2
        Case $3C,$3D,$3E,$3F
            setanimtime(arg0\Field3, 4.0, $00)
        Case $23
            use1123()
    End Select
    arg0\Field15 = $00
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
            Exit
        EndIf
    Next
    me\Field42 = max(2.0, me\Field42)
    mp_dropitem(arg0)
    catcherrors("Uncaught: DropItem()")
    Return $00
End Function

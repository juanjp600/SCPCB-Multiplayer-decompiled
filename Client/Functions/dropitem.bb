Function dropitem%(arg0.items, arg1%)
    Local local0%
    Local local2%
    If (multiplayer_isascp(myplayer\Field51) <> 0) Then
        Return $00
    EndIf
    If (arg0\Field15 = $00) Then
        Return $00
    EndIf
    If ((instr(arg0\Field3\Field2, "microhid", $01) And myplayer\Field82) <> 0) Then
        Return $00
    EndIf
    If (wearinghazmat > $00) Then
        msg = "You cannot drop any items while wearing a hazmat suit."
        msgtimer = 350.0
        Return $00
    EndIf
    If (arg1 <> 0) Then
        If (arg0\Field3\Field3 <> $42) Then
            playsound_strict(picksfx(arg0\Field3\Field3))
            multiplayer_writesound(picksfx(arg0\Field3\Field3), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 3.0, 1.0)
        EndIf
    EndIf
    showentity(arg0\Field1)
    positionentity(arg0\Field1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
    rotateentity(arg0\Field1, entitypitch(camera, $00), (entityyaw(camera, $00) + rnd(-20.0, 20.0)), 0.0, $00)
    moveentity(arg0\Field1, 0.0, -0.1, 0.1)
    rotateentity(arg0\Field1, 0.0, (entityyaw(camera, $00) + rnd(-110.0, 110.0)), 0.0, $00)
    resetentity(arg0\Field1)
    For local0 = $00 To $09 Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
        EndIf
    Next
    Select arg0\Field3\Field2
        Case "gasmask","supergasmask","gasmask3"
            wearinggasmask = $00
        Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
            wearinghazmat = $00
        Case "vest","finevest"
            wearingvest = $00
        Case "nvgoggles"
            If (wearingnightvision = $01) Then
                camerafogfar = storedcamerafogfar
                wearingnightvision = $00
            EndIf
        Case "supernv"
            If (wearingnightvision = $02) Then
                camerafogfar = storedcamerafogfar
                wearingnightvision = $00
            EndIf
        Case "finenvgoggles"
            If (wearingnightvision = $03) Then
                camerafogfar = storedcamerafogfar
                wearingnightvision = $00
            EndIf
        Case "scp714"
            wearing714 = $00
        Case "scp1499","super1499"
            wearing1499 = $00
        Case "scp427"
            i_427\Field0 = $00
    End Select
    If (networkserver\Field18 <> 0) Then
        arg0\Field22 = $00
        arg0\Field15 = $00
    EndIf
    If (udp_network\Field0 <> $00) Then
        udp_bytestreamwritechar($18)
        udp_bytestreamwriteshort(arg0\Field18)
        udp_setmicrobyte($18)
    EndIf
    If (isagun(arg0\Field3\Field2) <> 0) Then
        If (eqquipedgun <> Null) Then
            If (isagun(arg0\Field3\Field2) = eqquipedgun\Field0) Then
                eqquipedgun = Null
            EndIf
        EndIf
    EndIf
    If (arg0\Field19 <> $00) Then
        If (arg0\Field3\Field2 = "clipboard") Then
            arg0\Field16 = arg0\Field3\Field9
            setanimtime(arg0\Field2, 17.0, $00)
        ElseIf (arg0\Field3\Field2 = "wallet") Then
            setanimtime(arg0\Field2, 0.0, $00)
        EndIf
    EndIf
    For local2 = $00 To (arg0\Field19 - $01) Step $01
        If (arg0\Field17[local2] <> Null) Then
            dropitem(arg0\Field17[local2], $00)
            arg0\Field17[local2] = Null
        EndIf
    Next
    Return $00
End Function

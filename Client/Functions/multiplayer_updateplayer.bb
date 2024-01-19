Function multiplayer_updateplayer%(arg0.players)
    Local local0.breachtypes
    Local local1#
    Local local2#
    Local local3%
    Local local4%
    If (((arg0\Field12 = $00) Or (arg0\Field13 = $00)) <> 0) Then
        Return $00
    EndIf
    If (((arg0\Field33 = $01) Or (arg0\Field51 = $00)) <> 0) Then
        scp\Field5[arg0\Field0] = $00
        hideentity(arg0\Field12)
        hideentity(arg0\Field13)
        hideentity(arg0\Field19)
        arg0\Field78 = $00
        Return $00
    Else
        showentity(arg0\Field13)
        showentity(arg0\Field12)
        showentity(arg0\Field19)
    EndIf
    local0 = getbreachtype(arg0\Field51)
    If (arg0\Field40 <> $00) Then
        local0 = getbreachtype(classd_model)
    EndIf
    local1 = local0\Field52
    local2 = local0\Field53
    local3 = (Int local0\Field54)
    If (arg0\Field40 < $01) Then
        local4 = arg0\Field51
        If (local4 = model_966) Then
            If (((wearingnightvision = $00) And (multiplayer_isafriend(myplayer\Field51, arg0\Field51) = $00)) <> 0) Then
                local1 = 9999.0
            EndIf
        EndIf
    EndIf
    positionentity(arg0\Field13, curvevalue(arg0\Field1, entityx(arg0\Field13, $00), 4.0), curvevalue((arg0\Field2 + 0.32), entityy(arg0\Field13, $00), 4.0), curvevalue(arg0\Field3, entityz(arg0\Field13, $00), 4.0), $00)
    rotateentity(arg0\Field13, 0.0, curveangle(arg0\Field4, entityyaw(arg0\Field13, $00), 6.0), 0.0, $00)
    positionentity(arg0\Field12, entityx(arg0\Field13, $00), ((entityy(arg0\Field13, $00) - local1) - 0.32), entityz(arg0\Field13, $00), $00)
    rotateentity(arg0\Field12, (Float local3), (entityyaw(arg0\Field13, $00) + local2), 0.0, $01)
    If (arg0\Field15 <> $00) Then
        positionentity(arg0\Field14, entityx(arg0\Field15, $01), entityy(arg0\Field15, $01), entityz(arg0\Field15, $01), $00)
    Else
        positionentity(arg0\Field14, entityx(arg0\Field13, $01), (entityy(arg0\Field13, $01) + (arg0\Field92 * 0.7)), entityz(arg0\Field13, $01), $00)
    EndIf
    rotateentity(arg0\Field14, arg0\Field10, entityyaw(arg0\Field13, $00), 0.0, $01)
    resetentity(arg0\Field13)
    If (arg0\Field42\Field8 <> $00) Then
        If (arg0\Field78 <> 0) Then
            If ((((0.15 = local0\Field10) And (0.52 = local0\Field11)) And (0.15 = local0\Field12)) <> 0) Then
                rd_setforce(arg0\Field42\Field9[$00], ((arg0\Field6 - entityx(arg0\Field13, $00)) * 1.2), ((arg0\Field7 - entityy(arg0\Field13, $00)) * 1.2), ((arg0\Field8 - entityz(arg0\Field13, $00)) * 1.2))
                rd_setforce(arg0\Field42\Field9[$01], ((arg0\Field6 - entityx(arg0\Field13, $00)) * 1.2), ((arg0\Field7 - entityy(arg0\Field13, $00)) * 1.2), ((arg0\Field8 - entityz(arg0\Field13, $00)) * 1.2))
                rd_setforce(arg0\Field42\Field9[$00], 0.0, 0.0, ((arg0\Field9 - entityyaw(arg0\Field12, $00)) * 0.01))
                rd_setforce(arg0\Field42\Field9[$01], 0.0, 0.0, ((arg0\Field9 - entityyaw(arg0\Field12, $00)) * 0.01))
                rd_setforce(arg0\Field42\Field9[$00], 0.0, ((arg0\Field11 - arg0\Field10) * 0.01), 0.0)
                rd_setforce(arg0\Field42\Field9[$01], 0.0, ((arg0\Field11 - arg0\Field10) * 0.01), 0.0)
                showentity(arg0\Field42\Field8)
                arg0\Field6 = entityx(arg0\Field13, $00)
                arg0\Field7 = entityy(arg0\Field13, $00)
                arg0\Field8 = entityz(arg0\Field13, $00)
                arg0\Field9 = entityyaw(arg0\Field12, $00)
                arg0\Field11 = arg0\Field10
            Else
                hideentity(arg0\Field42\Field8)
            EndIf
        Else
            hideentity(arg0\Field42\Field8)
        EndIf
    EndIf
    arg0\Field78 = $01
    If (multiplayer_isafriend(myplayer\Field51, arg0\Field51) = $00) Then
        If (myplayer\Field51 = model_939) Then
            arg0\Field78 = $00
            hideentity(arg0\Field12)
            If (((0.01 < arg0\Field36) And (((arg0\Field55 >= $05) And (arg0\Field55 <= $0A)) = $00)) <> 0) Then
                showentity(arg0\Field12)
                arg0\Field78 = $01
            EndIf
        EndIf
    EndIf
    If ((hidedistance * 2.0) < entitydistance(arg0\Field13, collider)) Then
        hideentity(arg0\Field19)
        hideentity(arg0\Field12)
        arg0\Field78 = $00
    EndIf
    Return $00
End Function

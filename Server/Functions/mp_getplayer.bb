Function mp_getplayer%(arg0.players)
    Local local0#
    Local local1#
    Local local2%
    Local local4%
    Local local5.doors
    Local local6%
    If (arg0\Field30 < $01) Then
        Return $00
    EndIf
    If (arg0\Field61 <> 0) Then
        If (server\Field21 <> 0) Then
            setplayertype(arg0\Field30, $00)
        EndIf
    EndIf
    local0 = 0.3
    local1 = 180.0
    local2 = $00
    Select arg0\Field36
        Case model_966
            local0 = 0.2
        Case ntf_model
            local0 = 0.32
        Case guard_model
            local0 = 0.32
        Case model_049
            local0 = 0.32
        Case model_096
            local0 = 0.03
    End Select
    If (((arg0\Field36 = $00) Or arg0\Field61) <> 0) Then
        If (arg0\Field91 <> 0) Then
            hideentity(arg0\Field66)
            hideentity(arg0\Field64)
            hideentity(arg0\Field65)
            arg0\Field91 = $00
        EndIf
        arg0\Field88 = 0.01
    ElseIf (arg0\Field91 = $00) Then
        showentity(arg0\Field66)
        showentity(arg0\Field64)
        showentity(arg0\Field65)
        arg0\Field91 = $01
        arg0\Field88 = 0.01
    EndIf
    If (((arg0\Field36 = model_096) And (arg0\Field37 = $0D)) <> 0) Then
        For local5 = Each doors
            If (1.75 > entitydistance(arg0\Field64, local5\Field2)) Then
                If (local5\Field4 = $00) Then
                    If ((((local5\Field9 = $00) Or (local5\Field9 = $01)) Or (local5\Field9 = $02)) <> 0) Then
                        local5\Field5 = $01
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    tracecamera(arg0\Field30)
    positionentity(arg0\Field64, entityx(arg0\Field65, $00), (entityy(arg0\Field65, $00) + 0.32), entityz(arg0\Field65, $00), $00)
    rotateentity(arg0\Field64, 0.0, arg0\Field145, 0.0, $00)
    resetentity(arg0\Field64)
    positionentity(arg0\Field66, entityx(arg0\Field64, $00), ((entityy(arg0\Field64, $00) - local0) - 0.32), entityz(arg0\Field64, $00), $00)
    rotateentity(arg0\Field66, (Float local2), (entityyaw(arg0\Field64, $00) - local1), 0.0, $01)
    arg0\Field92 = -1.0
    mp_updateplayerstate(arg0)
    If ((server\Field71 And (arg0\Field36 > $00)) <> 0) Then
        If (arg0\Field96 = $00) Then
            If (arg0\Field166 = arg0\Field167) Then
                If (((server\Field72 * arg0\Field176) * arg0\Field120) < distance(entityx(arg0\Field65, $00), entityz(arg0\Field65, $00), arg0\Field0, arg0\Field2)) Then
                    arg0\Field177 = -1.0
                EndIf
            EndIf
            If (0.0 <= arg0\Field177) Then
                If (2.0 < distance3(arg0\Field0, arg0\Field1, arg0\Field2, entityx(arg0\Field65, $00), entityy(arg0\Field65, $00), entityz(arg0\Field65, $00))) Then
                    arg0\Field177 = (arg0\Field177 - fpsfactor)
                Else
                    arg0\Field177 = 70.0
                    arg0\Field153 = entityx(arg0\Field65, $00)
                    arg0\Field154 = entityy(arg0\Field65, $00)
                    arg0\Field155 = entityz(arg0\Field65, $00)
                    arg0\Field173 = arg0\Field32
                EndIf
            EndIf
        EndIf
        If (1.0 > arg0\Field177) Then
            setplayerpositionex(arg0\Field30, arg0\Field173, arg0\Field153, arg0\Field154, arg0\Field155)
            arg0\Field177 = 70.0
        ElseIf (arg0\Field166 = arg0\Field167) Then
            positionentity(arg0\Field65, curvevalue(arg0\Field0, entityx(arg0\Field65, $00), 5.0), curvevalue(arg0\Field1, entityy(arg0\Field65, $00), 5.0), curvevalue(arg0\Field2, entityz(arg0\Field65, $00), 5.0), $00)
            If (arg0\Field96 <> 0) Then
                resetentity(arg0\Field65)
            EndIf
        EndIf
    Else
        positionentity(arg0\Field65, curvevalue(arg0\Field0, entityx(arg0\Field65, $00), 5.0), curvevalue(arg0\Field1, entityy(arg0\Field65, $00), 5.0), curvevalue(arg0\Field2, entityz(arg0\Field65, $00), 5.0), $00)
        resetentity(arg0\Field65)
    EndIf
    arg0\Field38 = ((((((readbool(arg0\Field38, $00) + (readbool(arg0\Field38, $01) Shl $01)) + (readbool(arg0\Field38, $02) Shl $02)) + (readbool(arg0\Field38, $03) Shl $03)) + (arg0\Field61 Shl $04)) + (readbool(arg0\Field38, $05) Shl $05)) + (readbool(arg0\Field38, $06) Shl $06))
    If (arg0\Field36 = model_035) Then
        If (giveplayerhealth(arg0\Field30, (-0.1 * fpsfactor), "was decomposed") <> 0) Then
            If (getscripts() <> 0) Then
                local6 = public_inqueue($19, $00)
                public_addparam(local6, (Str arg0\Field30), $01)
                public_addparam(local6, (Str arg0\Field30), $01)
                public_addparam(local6, "0", $01)
                callback($00)
            EndIf
        EndIf
        If (500.0 < arg0\Field62) Then
            arg0\Field63 = 0.0
        EndIf
    EndIf
    updateplayersize(arg0\Field30)
    Return $00
End Function

Function mp_getplayer%(arg0.players)
    Local local0#
    Local local1#
    Local local2%
    Local local4%
    Local local5.doors
    Local local6%
    Local local7.bs
    Local local8%
    Local local9%
    Local local10.items
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    Local local15#
    Local local16#
    Local local17%
    If (arg0\Field30 < $01) Then
        Return $00
    EndIf
    If (arg0\Field59 <> 0) Then
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
    If (((arg0\Field36 = $00) Or arg0\Field59) <> 0) Then
        If (arg0\Field89 <> 0) Then
            hideentity(arg0\Field64)
            hideentity(arg0\Field62)
            hideentity(arg0\Field63)
            arg0\Field89 = $00
        EndIf
        arg0\Field86 = 0.01
    ElseIf (arg0\Field89 = $00) Then
        showentity(arg0\Field64)
        showentity(arg0\Field62)
        showentity(arg0\Field63)
        arg0\Field89 = $01
        arg0\Field86 = 0.01
    EndIf
    If (((arg0\Field36 = model_096) And (arg0\Field37 = $0D)) <> 0) Then
        For local5 = Each doors
            If (1.5 > entitydistance(arg0\Field62, local5\Field2)) Then
                If (local5\Field4 = $00) Then
                    If (((local5\Field9 = $00) Or (local5\Field9 = $01)) <> 0) Then
                        local5\Field5 = $01
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    tracecamera(arg0\Field30)
    positionentity(arg0\Field62, entityx(arg0\Field63, $00), (entityy(arg0\Field63, $00) + 0.32), entityz(arg0\Field63, $00), $00)
    rotateentity(arg0\Field62, 0.0, arg0\Field142, 0.0, $00)
    resetentity(arg0\Field62)
    positionentity(arg0\Field64, entityx(arg0\Field62, $00), ((entityy(arg0\Field62, $00) - local0) - 0.32), entityz(arg0\Field62, $00), $00)
    rotateentity(arg0\Field64, (Float local2), (entityyaw(arg0\Field62, $00) - local1), 0.0, $01)
    arg0\Field90 = -1.0
    mp_updateplayerstate(arg0)
    If ((server\Field73 And (arg0\Field36 > $00)) <> 0) Then
        If (arg0\Field94 = $00) Then
            If (arg0\Field163 = arg0\Field164) Then
                If (((server\Field74 * arg0\Field173) * arg0\Field118) < distance(entityx(arg0\Field63, $00), entityz(arg0\Field63, $00), arg0\Field0, arg0\Field2)) Then
                    arg0\Field174 = -1.0
                EndIf
            EndIf
            If (0.0 <= arg0\Field174) Then
                If (2.0 < distance3(arg0\Field0, arg0\Field1, arg0\Field2, entityx(arg0\Field63, $00), entityy(arg0\Field63, $00), entityz(arg0\Field63, $00))) Then
                    arg0\Field174 = (arg0\Field174 - fpsfactor)
                Else
                    arg0\Field174 = 70.0
                    arg0\Field150 = entityx(arg0\Field63, $00)
                    arg0\Field151 = entityy(arg0\Field63, $00)
                    arg0\Field152 = entityz(arg0\Field63, $00)
                    arg0\Field170 = arg0\Field32
                EndIf
            EndIf
        EndIf
        If (1.0 > arg0\Field174) Then
            setplayerpositionex(arg0\Field30, arg0\Field170, arg0\Field150, arg0\Field151, arg0\Field152)
            arg0\Field174 = 70.0
        ElseIf (arg0\Field163 = arg0\Field164) Then
            positionentity(arg0\Field63, curvevalue(arg0\Field0, entityx(arg0\Field63, $00), 5.0), curvevalue(arg0\Field1, entityy(arg0\Field63, $00), 5.0), curvevalue(arg0\Field2, entityz(arg0\Field63, $00), 5.0), $00)
            If (arg0\Field94 <> 0) Then
                resetentity(arg0\Field63)
            EndIf
        EndIf
    Else
        positionentity(arg0\Field63, curvevalue(arg0\Field0, entityx(arg0\Field63, $00), 5.0), curvevalue(arg0\Field1, entityy(arg0\Field63, $00), 5.0), curvevalue(arg0\Field2, entityz(arg0\Field63, $00), 5.0), $00)
        resetentity(arg0\Field63)
    EndIf
    arg0\Field38 = ((((((readbool(arg0\Field38, $00) + (readbool(arg0\Field38, $01) Shl $01)) + (readbool(arg0\Field38, $02) Shl $02)) + (readbool(arg0\Field38, $03) Shl $03)) + (arg0\Field59 Shl $04)) + (readbool(arg0\Field38, $05) Shl $05)) + (readbool(arg0\Field38, $06) Shl $06))
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
        If (500.0 < arg0\Field60) Then
            arg0\Field61 = 0.0
        EndIf
    EndIf
    updateplayersize(arg0\Field30)
    If (arg0\Field176 > $00) Then
        If ((((arg0\Field36 > $00) And (arg0\Field59 = $00)) And (arg0\Field138 = $00)) <> 0) Then
            local7 = createbytestream((arg0\Field176 * $17))
            For local8 = $01 To arg0\Field176 Step $01
                local9 = bytestreamreadshort(arg0\Field175[local8])
                If (local9 < $3E8) Then
                    local10 = m_item[local9]
                    If (local10 <> Null) Then
                        If (((local10\Field22 = arg0\Field30) And (isagun(local10\Field3\Field2) = arg0\Field35)) <> 0) Then
                            local11 = bytestreamreadfloat(arg0\Field175[local8])
                            local12 = bytestreamreadfloat(arg0\Field175[local8])
                            local13 = bytestreamreadfloat(arg0\Field175[local8])
                            local14 = bytestreamreadfloat(arg0\Field175[local8])
                            local15 = bytestreamreadfloat(arg0\Field175[local8])
                            local16 = max(((Float bytestreamreadchar(arg0\Field175[local8])) / 10.0), 0.7)
                            If (((mp_isascp(arg0\Field36) = $00) And (4.0 > distance3(local11, local12, local13, entityx(arg0\Field62, $00), entityy(arg0\Field62, $00), entityz(arg0\Field62, $00)))) <> 0) Then
                                If (getscripts() <> 0) Then
                                    local6 = public_inqueue($0D, $00)
                                    public_addparam(local6, (Str arg0\Field30), $01)
                                    public_addparam(local6, (Str local11), $02)
                                    public_addparam(local6, (Str local12), $02)
                                    public_addparam(local6, (Str local13), $02)
                                    public_addparam(local6, (Str local15), $02)
                                    public_addparam(local6, (Str local14), $02)
                                    callback($00)
                                EndIf
                                If (se_return_value\Field8 = $00) Then
                                    If (((local15 = arg0\Field4) Or (local14 = arg0\Field5)) <> 0) Then
                                        oncheatdetected(arg0\Field30, $07)
                                    EndIf
                                    arg0\Field4 = local15
                                    arg0\Field5 = local14
                                    local17 = getgunshootticks(arg0\Field35)
                                    For local8 = $01 To local17 Step $01
                                        createbullet(arg0\Field30, 0.6, local11, local12, local13, (rnd((getgunspreadrate(arg0\Field35) * (- local16)), (getgunspreadrate(arg0\Field35) * local16)) + local14), (rnd((getgunspreadrate(arg0\Field35) * (- local16)), (getgunspreadrate(arg0\Field35) * local16)) + local15), arg0\Field35)
                                    Next
                                    bytestreamwriteshort(local7, $00)
                                    bytestreamwritefloat(local7, local11)
                                    bytestreamwritefloat(local7, local12)
                                    bytestreamwritefloat(local7, local13)
                                    bytestreamwritefloat(local7, local14)
                                    bytestreamwritefloat(local7, local15)
                                    bytestreamwritechar(local7, (Int (local16 * 10.0)))
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Next
            For local8 = $01 To server\Field11 Step $01
                If (50.0 > distance3(local11, local12, local13, entityx(playeroptimize[local8]\Field62, $00), entityy(playeroptimize[local8]\Field62, $00), entityz(playeroptimize[local8]\Field62, $00))) Then
                    udp_writebyte($6B)
                    udp_writebyte(arg0\Field30)
                    udp_writebytes(getbytestreamdata(local7), $00, getbytestreamdatasize(local7))
                    udp_sendmessage(playeroptimize[local8]\Field30)
                EndIf
            Next
            removebytestream(local7)
        EndIf
        For local8 = $01 To arg0\Field176 Step $01
            removebytestream(arg0\Field175[local8])
        Next
        arg0\Field176 = $00
    EndIf
    Return $00
End Function

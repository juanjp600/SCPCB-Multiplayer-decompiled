Function updatezonecolor%()
    Local local0%
    Local local1%
    Local local3#
    Local local4#
    Local local5#
    Local local7%
    local1 = (isplayeroutsidefacility() Lor (playerroom\Field7\Field6 = $04))
    fog\Field1 = ""
    fog\Field2 = ""
    camerafogmode(camera, $01)
    camerafogrange(camera, (0.1 * lightvolume), (fog\Field0 * lightvolume))
    camerarange(camera, 0.01, (((((Float (opt\Field51 = $00)) * fog\Field0) * lightvolume) * 1.3) + ((Float opt\Field51) * 100.0)))
    If (((playerroom\Field7\Field6 = $1F) And (infacility = $FFFFFFFF)) <> 0) Then
        setzonecolor("002007000", "030030030")
    ElseIf (local1 <> 0) Then
        setzonecolor("255255255", "030030030")
        fog\Field0 = 60.0
        lightvolume = 1.0
        camerafogrange(camera, 5.0, fog\Field0)
        camerarange(camera, 0.01, 72.0)
    ElseIf (playerroom\Field7\Field6 = $6A) Then
        setzonecolor("096097104", "030030030")
        fog\Field0 = 80.0
        lightvolume = 1.0
        camerafogrange(camera, 40.0, fog\Field0)
        camerarange(camera, 0.01, 96.0)
    ElseIf (((pd_event <> Null) And (pd_event\Field1 = playerroom)) <> 0) Then
        lightvolume = 1.0
        If (((3.0 = pd_event\Field3) Lor (6.0 = pd_event\Field3)) <> 0) Then
            setzonecolor("038055047", "030030030")
        ElseIf (5.0 = pd_event\Field3) Then
            setzonecolor("007002002", "030023023")
        Else
            setzonecolor("000000000", "030030030")
        EndIf
    ElseIf (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
        If (20.0 < entityy(me\Field60, $00)) Then
            If (0.0 = forest_event\Field5) Then
                setzonecolor("098133162", "030030030")
                fog\Field0 = 8.0
                lightvolume = 1.0
            Else
                setzonecolor("045020020", "030030030")
                fog\Field0 = 5.0
                lightvolume = 0.8
            EndIf
            If (forest_event\Field1\Field15[$00] <> Null) Then
                If (2.0 <= forest_event\Field1\Field15[$00]\Field10) Then
                    setzonecolor("032044054", "030030030")
                EndIf
            EndIf
            camerafogrange(camera, 0.1, fog\Field0)
            camerarange(camera, 0.01, (fog\Field0 * 1.2))
        EndIf
    EndIf
    If (fog\Field1 = "") Then
        Select me\Field59
            Case $00
                setzonecolor("005005005", "030030030")
            Case $01
                setzonecolor("007002002", "030023023")
            Case $02
                setzonecolor("007007012", "023023030")
        End Select
    EndIf
    fog\Field3 = curvevalue((Float left(fog\Field1, $03)), fog\Field3, 50.0)
    fog\Field4 = curvevalue((Float mid(fog\Field1, $04, $03)), fog\Field4, 50.0)
    fog\Field5 = curvevalue((Float right(fog\Field1, $03)), fog\Field5, 50.0)
    camerafogcolor(camera, fog\Field3, fog\Field4, fog\Field5)
    cameraclscolor(camera, (fog\Field3 * (Float (local1 = $00))), (fog\Field4 * (Float (local1 = $00))), (fog\Field5 * (Float (local1 = $00))))
    fog\Field6 = (Int left(fog\Field2, $03))
    fog\Field7 = (Int mid(fog\Field2, $04, $03))
    fog\Field8 = (Int right(fog\Field2, $03))
    fog\Field9 = curvevalue((Float fog\Field6), fog\Field9, 50.0)
    fog\Field10 = curvevalue((Float fog\Field7), fog\Field10, 50.0)
    fog\Field11 = curvevalue((Float fog\Field8), fog\Field11, 50.0)
    local3 = fog\Field9
    local4 = fog\Field10
    local5 = fog\Field11
    If (wi\Field9 > $00) Then
        local3 = (local3 * 2.0)
        local4 = (local4 * 2.0)
        local5 = (local5 * 2.0)
    Else
        Select wi\Field5
            Case $00
                If (((forest_event <> Null) And (forest_event\Field1 = playerroom)) <> 0) Then
                    If (20.0 < entityy(me\Field60, $00)) Then
                        local3 = 200.0
                        local4 = 200.0
                        local5 = 200.0
                    EndIf
                EndIf
            Case $01
                local3 = (local3 * 3.0)
                local4 = (local4 * 6.0)
                local5 = (local5 * 3.0)
            Case $02
                local3 = (local3 * 3.0)
                local4 = (local4 * 3.0)
                local5 = (local5 * 6.0)
            Case $03
                local3 = (local3 * 6.0)
                local4 = (local4 * 3.0)
                local5 = (local5 * 3.0)
        End Select
    EndIf
    If ((((isequal(fog\Field9, (Float fog\Field6), 0.01) = $00) Lor (isequal(fog\Field10, (Float fog\Field7), 0.01) = $00)) Lor (isequal(fog\Field11, (Float fog\Field8), 0.01) = $00)) <> 0) Then
        local7 = backbuffer()
        setbuffer(texturebuffer(ambientlightroomtex, $00))
        clscolor((Int (local3 / 3.0)), (Int (local4 / 3.0)), (Int (local5 / 3.0)))
        cls()
        clscolor($00, $00, $00)
        setbuffer(local7)
        ambientlight(local3, local4, local5)
    EndIf
    Return $00
End Function

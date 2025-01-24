Function loadmap%(arg0$)
    Local local0.rooms
    Local local1.roomtemplates
    Local local2.events
    Local local3%
    Local local4%
    Local local5%
    Local local6$
    Local local7%
    Local local8%
    Local local9#
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14.rooms
    Local local15.forest
    Local local17.rooms
    Local local19%
    Local local20%
    Local local21%
    Local local24.rooms
    catcherrors((("LoadMap(" + arg0) + ")"))
    local3 = readfile_strict(arg0)
    Delete currmapgrid
    currmapgrid = (New mapgrid)
    If (right(arg0, $06) = "cbmap2") Then
        readline(local3)
        readline(local3)
        i_zone\Field0[$00] = readbyte(local3)
        i_zone\Field0[$01] = readbyte(local3)
        local10 = readint(local3)
        local11 = readint(local3)
        local12 = readint(local3)
        i_zone\Field1 = (local11 > $00)
        i_zone\Field2 = (local12 > $00)
        For local13 = $00 To (local10 - $01) Step $01
            local4 = readbyte(local3)
            local5 = readbyte(local3)
            local6 = lower(readstring(local3))
            local7 = findroomid(local6)
            local8 = (Int ((Float readbyte(local3)) * 90.0))
            For local1 = Each roomtemplates
                If (local1\Field6 = local7) Then
                    If (((90.0 <> (Float local8)) And (270.0 <> (Float local8))) <> 0) Then
                        local8 = (Int ((Float local8) + 180.0))
                    EndIf
                    local8 = (Int wrapangle((Float local8), 360.0))
                    local0 = createroom($00, local1\Field4, ((Float ($15 - local4)) * 8.0), 0.0, ((Float local5) * 8.0), local7, (Float local8))
                    calculateroomextents(local0)
                    currmapgrid\Field0[(($15 - local4) + (local5 * $15))] = $01
                    Exit
                EndIf
            Next
            local6 = readstring(local3)
            local7 = findeventid(local6)
            local9 = readfloat(local3)
            If (local0 <> Null) Then
                If (0.0 < local9) Then
                    If (local9 >= rnd(0.0, 1.0)) Then
                        local2 = (New events)
                        local2\Field0 = local7
                        findeventvariable(local2)
                        local2\Field1 = local0
                    EndIf
                ElseIf (((0.0 = local9) And (local6 <> "")) <> 0) Then
                    local2 = (New events)
                    local2\Field0 = local7
                    findeventvariable(local2)
                    local2\Field1 = local0
                EndIf
            EndIf
        Next
        For local0 = Each rooms
            If (local0\Field7\Field6 = $5D) Then
                local14 = local0
                Exit
            EndIf
        Next
        If (local14 <> Null) Then
            local15 = (New forest)
        EndIf
        For local13 = $00 To (local11 - $01) Step $01
            local4 = readbyte(local3)
            local5 = readbyte(local3)
            local6 = readstring(local3)
            local8 = readbyte(local3)
            If (((0.0 <> (Float local8)) And (2.0 <> (Float local8))) <> 0) Then
                local8 = (Int ((Float local8) + 2.0))
            EndIf
            local8 = (Int ((Float local8) + 1.0))
            If (3.0 < (Float local8)) Then
                local8 = (Int ((Float local8) Mod 4.0))
            EndIf
            local4 = ($09 - local4)
            If (local15 <> Null) Then
                Select local6
                    Case "scp-860-1 endroom"
                        local15\Field2[((local5 * $0A) + local4)] = (Int ((Float local8) + 1.0))
                    Case "scp-860-1 path"
                        local15\Field2[((local5 * $0A) + local4)] = (Int ((Float local8) + 5.0))
                    Case "scp-860-1 corner"
                        local15\Field2[((local5 * $0A) + local4)] = (Int ((Float local8) + 9.0))
                    Case "scp-860-1 t-shaped path"
                        local15\Field2[((local5 * $0A) + local4)] = (Int ((Float local8) + 13.0))
                    Case "scp-860-1 4-way path"
                        local15\Field2[((local5 * $0A) + local4)] = (Int ((Float local8) + 17.0))
                    Case "scp-860-1 door"
                        local15\Field2[((local5 * $0A) + local4)] = (Int ((Float local8) + 21.0))
                End Select
            EndIf
        Next
        If (local15 <> Null) Then
            local14\Field10 = local15
            placemapcreatorforest(local14\Field10, local14\Field3, (local14\Field4 + 30.0), local14\Field5, local14)
        EndIf
        For local0 = Each rooms
            If (local0\Field7\Field6 = $33) Then
                local17 = local0
                Exit
            EndIf
        Next
        If (local17 <> Null) Then
            local17\Field18 = (New mtgrid)
        EndIf
        For local13 = $00 To (local12 - $01) Step $01
            local4 = readbyte(local3)
            local5 = readbyte(local3)
            local6 = readstring(local3)
            local8 = readbyte(local3)
            If (((1.0 <> (Float local8)) And (3.0 <> (Float local8))) <> 0) Then
                local8 = (Int ((Float local8) + 2.0))
            EndIf
            If (((local6 = "maintenance tunnel corner") Lor (local6 = "maintenance tunnel t-shaped room")) <> 0) Then
                local8 = (Int ((Float local8) + 3.0))
            EndIf
            If (3.0 < (Float local8)) Then
                local8 = (Int ((Float local8) Mod 4.0))
            EndIf
            local4 = ($12 - local4)
            If (local17 <> Null) Then
                Select local6
                    Case "maintenance tunnel endroom"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $01
                    Case "maintenance tunnel corridor"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $02
                    Case "maintenance tunnel corner"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $03
                    Case "maintenance tunnel t-shaped room"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $04
                    Case "maintenance tunnel 4-way room"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $05
                    Case "maintenance tunnel elevator"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $06
                    Case "maintenance tunnel generator room"
                        local17\Field18\Field0[((local5 * $13) + local4)] = $07
                End Select
                local17\Field18\Field1[((local5 * $13) + local4)] = local8
            EndIf
        Next
    Else
        i_zone\Field0[$00] = $0D
        i_zone\Field0[$01] = $07
        i_zone\Field1 = $00
        i_zone\Field2 = $00
        While (eof(local3) = $00)
            local4 = readbyte(local3)
            local5 = readbyte(local3)
            local6 = lower(readstring(local3))
            local7 = findroomid(local6)
            local8 = (Int ((Float readbyte(local3)) * 90.0))
            For local1 = Each roomtemplates
                If (local1\Field6 = local7) Then
                    If (((90.0 <> (Float local8)) And (270.0 <> (Float local8))) <> 0) Then
                        local8 = (Int ((Float local8) + 180.0))
                    EndIf
                    local8 = (Int wrapangle((Float local8), 360.0))
                    local0 = createroom($00, local1\Field4, ((Float ($15 - local4)) * 8.0), 0.0, ((Float local5) * 8.0), local7, (Float local8))
                    calculateroomextents(local0)
                    currmapgrid\Field0[(($15 - local4) + (local5 * $15))] = $01
                    Exit
                EndIf
            Next
            local6 = readstring(local3)
            local7 = findeventid(local6)
            local9 = readfloat(local3)
            If (local0 <> Null) Then
                If (0.0 < local9) Then
                    If (local9 >= rnd(0.0, 1.0)) Then
                        local2 = (New events)
                        local2\Field0 = local7
                        findeventvariable(local2)
                        local2\Field1 = local0
                    EndIf
                ElseIf (((0.0 = local9) And (local6 <> "")) <> 0) Then
                    local2 = (New events)
                    local2\Field0 = local7
                    findeventvariable(local2)
                    local2\Field1 = local0
                EndIf
            EndIf
        Wend
    EndIf
    closefile(local3)
    local5 = $15
    While (local5 >= $00)
        If (local5 < i_zone\Field0[$01]) Then
            local20 = $03
        ElseIf (((local5 >= i_zone\Field0[$01]) And (local5 < i_zone\Field0[$00])) <> 0) Then
            local20 = $02
        Else
            local20 = $01
        EndIf
        local4 = $15
        While (local4 >= $00)
            If (currmapgrid\Field0[((local5 * $15) + local4)] > $00) Then
                For local0 = Each rooms
                    local0\Field6 = (Int wrapangle((Float local0\Field6), 360.0))
                    If ((((Int (local0\Field3 / 8.0)) = local4) And ((Int (local0\Field5 / 8.0)) = local5)) <> 0) Then
                        Select local0\Field7\Field4
                            Case $00
                                local21 = (90.0 = (Float local0\Field6))
                            Case $01
                                local21 = ((90.0 = (Float local0\Field6)) Lor (270.0 = (Float local0\Field6)))
                            Case $02
                                local21 = ((0.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6)))
                            Case $03
                                local21 = (((0.0 = (Float local0\Field6)) Lor (180.0 = (Float local0\Field6))) Lor (90.0 = (Float local0\Field6)))
                            Default
                                local21 = $01
                        End Select
                        If (local21 <> 0) Then
                            If ((local4 + $01) < $16) Then
                                If (currmapgrid\Field0[((local4 + $01) + (local5 * $15))] > $00) Then
                                    local0\Field20[$00] = createdoor(local0, (((Float local4) * 8.0) + 4.0), 0.0, ((Float local5) * 8.0), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), (((local20 - $01) Mod $02) Shl $01), $00, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        Select local0\Field7\Field4
                            Case $00
                                local21 = (180.0 = (Float local0\Field6))
                            Case $01
                                local21 = ((0.0 = (Float local0\Field6)) Lor (180.0 = (Float local0\Field6)))
                            Case $02
                                local21 = ((180.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6)))
                            Case $03
                                local21 = (((180.0 = (Float local0\Field6)) Lor (90.0 = (Float local0\Field6))) Lor (270.0 = (Float local0\Field6)))
                            Default
                                local21 = $01
                        End Select
                        If (local21 <> 0) Then
                            If ((local5 + $01) < $16) Then
                                If (currmapgrid\Field0[(((local5 + $01) * $15) + local4)] > $00) Then
                                    local0\Field20[$03] = createdoor(local0, ((Float local4) * 8.0), 0.0, (((Float local5) * 8.0) + 4.0), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), (((local20 - $01) Mod $02) Shl $01), $00, $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local4 = (local4 + $FFFFFFFF)
        Wend
        local5 = (local5 + $FFFFFFFF)
    Wend
    local0 = createroom($00, $00, 0.0, 500.0, -80.0, $49, 0.0)
    calculateroomextents(local0)
    createevent($2C, $49, $00, 0.0)
    local0 = createroom($00, $00, 0.0, 500.0, -16.0, $47, 0.0)
    calculateroomextents(local0)
    createevent($2E, $47, $00, 0.0)
    local0 = createroom($00, $00, 184.0, 0.0, 184.0, $69, 0.0)
    calculateroomextents(local0)
    createevent($48, $69, $00, 0.0)
    If (opt\Field50 <> 0) Then
        local0 = createroom($00, $00, 8.0, 250.0, 184.0, $04, 0.0)
        calculateroomextents(local0)
        createevent($04, $04, $00, 0.0)
    EndIf
    local0 = createroom($00, $00, -16.0, 800.0, 0.0, $6A, 0.0)
    calculateroomextents(local0)
    createevent($49, $6A, $00, 0.0)
    For local0 = Each rooms
        For local13 = $00 To $03 Step $01
            local0\Field19[local13] = Null
        Next
        For local24 = Each rooms
            If (local0 <> local24) Then
                If (local0\Field5 = local24\Field5) Then
                    If ((local0\Field3 + 8.0) = local24\Field3) Then
                        local0\Field19[$00] = local24
                        If (local0\Field20[$00] = Null) Then
                            local0\Field20[$00] = local24\Field20[$02]
                        EndIf
                    ElseIf ((local0\Field3 - 8.0) = local24\Field3) Then
                        local0\Field19[$02] = local24
                        If (local0\Field20[$02] = Null) Then
                            local0\Field20[$02] = local24\Field20[$00]
                        EndIf
                    EndIf
                ElseIf (local0\Field3 = local24\Field3) Then
                    If ((local0\Field5 - 8.0) = local24\Field5) Then
                        local0\Field19[$01] = local24
                        If (local0\Field20[$01] = Null) Then
                            local0\Field20[$01] = local24\Field20[$03]
                        EndIf
                    ElseIf ((local0\Field5 + 8.0) = local24\Field5) Then
                        local0\Field19[$03] = local24
                        If (local0\Field20[$03] = Null) Then
                            local0\Field20[$03] = local24\Field20[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local0\Field19[$00] <> Null) And (local0\Field19[$01] <> Null)) And (local0\Field19[$02] <> Null)) And (local0\Field19[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
    Next
    catcherrors((("Uncaught: LoadMap(" + arg0) + ")"))
    Return $00
End Function

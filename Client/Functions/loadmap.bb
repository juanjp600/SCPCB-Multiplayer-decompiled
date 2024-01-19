Function loadmap%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4%
    Local local5#
    Local local6.rooms
    Local local7.roomtemplates
    Local local8.events
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13.rooms
    Local local14.forest
    Local local16.rooms
    Local local18%
    Local local19%
    Local local20#
    Local local21%
    Local local22.doors
    Local local25.rooms
    debuglog((Str filesize(arg0)))
    local0 = readfile(arg0)
    debuglog(arg0)
    Dim maptemp%((mapwidth + $02), (mapheight + $02))
    Dim mapfound%((mapwidth + $02), (mapheight + $02))
    coffindistance = 100.0
    For local1 = $00 To (mapwidth + $01) Step $01
        For local2 = $00 To (mapheight + $01) Step $01
            maptemp(local1, local2) = $00
            mapfound(local1, local2) = $00
        Next
    Next
    If (right(arg0, $06) = "cbmap2") Then
        readline(local0)
        readline(local0)
        i_zone\Field0[$00] = readbyte(local0)
        i_zone\Field0[$01] = readbyte(local0)
        local9 = readint(local0)
        local10 = readint(local0)
        local11 = readint(local0)
        If (local10 > $00) Then
            i_zone\Field1 = $01
        EndIf
        If (local11 > $00) Then
            i_zone\Field2 = $01
        EndIf
        For local12 = $00 To (local9 - $01) Step $01
            local1 = readbyte(local0)
            local2 = readbyte(local0)
            local3 = lower(readstring(local0))
            local4 = (Int ((Float readbyte(local0)) * 90.0))
            debuglog((((((Str local1) + ", ") + (Str local2)) + ": ") + local3))
            debuglog(("angle: " + (Str local4)))
            For local7 = Each roomtemplates
                If (lower(local7\Field11) = local3) Then
                    local6 = createroom($00, local7\Field10, ((Float (mapwidth - local1)) * 8.0), 0.0, ((Float local2) * 8.0), local3)
                    debuglog("createroom")
                    local6\Field6 = local4
                    If (((local6\Field6 <> $5A) And (local6\Field6 <> $10E)) <> 0) Then
                        local6\Field6 = (local6\Field6 + $B4)
                    EndIf
                    local6\Field6 = (Int wrapangle((Float local6\Field6)))
                    turnentity(local6\Field2, 0.0, (Float local6\Field6), 0.0, $00)
                    maptemp((mapwidth - local1), local2) = $01
                    Exit
                EndIf
            Next
            local3 = readstring(local0)
            local5 = readfloat(local0)
            If (local6 <> Null) Then
                If (0.0 < local5) Then
                    If (local5 >= rnd(0.0, 1.0)) Then
                        local8 = (New events)
                        local8\Field0 = local3
                        local8\Field1 = local6
                        seteventvar(local8)
                        local8\Field22 = findeventconst(local8\Field0)
                    EndIf
                ElseIf (((0.0 = local5) And (local3 <> "")) <> 0) Then
                    local8 = (New events)
                    local8\Field0 = local3
                    local8\Field1 = local6
                    seteventvar(local8)
                    local8\Field22 = findeventconst(local8\Field0)
                EndIf
            EndIf
        Next
        For local6 = Each rooms
            If (local6\Field7\Field11 = "room860") Then
                local13 = local6
                Exit
            EndIf
        Next
        If (local13 <> Null) Then
            local14 = (New forest)
        EndIf
        For local12 = $00 To (local10 - $01) Step $01
            local1 = readbyte(local0)
            local2 = readbyte(local0)
            local3 = lower(readstring(local0))
            local4 = readbyte(local0)
            debuglog((((((Str local1) + ", ") + (Str local2)) + ": ") + local3))
            debuglog(("angle: " + (Str local4)))
            If (((local4 <> $00) And (local4 <> $02)) <> 0) Then
                local4 = (local4 + $02)
            EndIf
            local4 = (local4 + $01)
            If (local4 > $03) Then
                local4 = (local4 Mod $04)
            EndIf
            local1 = ($09 - local1)
            If (local14 <> Null) Then
                Select local3
                    Case "scp-860-1 endroom"
                        local14\Field2[((local2 * $0A) + local1)] = ($01 + local4)
                    Case "scp-860-1 path"
                        local14\Field2[((local2 * $0A) + local1)] = ($05 + local4)
                    Case "scp-860-1 corner"
                        local14\Field2[((local2 * $0A) + local1)] = ($09 + local4)
                    Case "scp-860-1 t-shaped path"
                        local14\Field2[((local2 * $0A) + local1)] = ($0D + local4)
                    Case "scp-860-1 4-way path"
                        local14\Field2[((local2 * $0A) + local1)] = ($11 + local4)
                    Case "scp-860-1 door"
                        local14\Field2[((local2 * $0A) + local1)] = ($15 + local4)
                End Select
                debuglog((((("created forest piece " + chr($22)) + local3) + chr($22)) + " successfully"))
            EndIf
        Next
        If (local14 <> Null) Then
            local13\Field11 = local14
            placeforest_mapcreator(local13\Field11, local13\Field3, (local13\Field4 + 30.0), local13\Field5, local13)
        EndIf
        For local6 = Each rooms
            If (local6\Field7\Field11 = "room2tunnel") Then
                local16 = local6
                Exit
            EndIf
        Next
        If (local16 <> Null) Then
            local16\Field33 = (New grids)
        EndIf
        For local12 = $00 To (local11 - $01) Step $01
            local1 = readbyte(local0)
            local2 = readbyte(local0)
            local3 = lower(readstring(local0))
            local4 = readbyte(local0)
            debuglog((((((Str local1) + ", ") + (Str local2)) + ": ") + local3))
            debuglog(("angle: " + (Str local4)))
            If (((local4 <> $01) And (local4 <> $03)) <> 0) Then
                local4 = (local4 + $02)
            EndIf
            If (((local3 = "maintenance tunnel corner") Or (local3 = "maintenance tunnel t-shaped room")) <> 0) Then
                local4 = (local4 + $03)
            EndIf
            If (local4 > $03) Then
                local4 = (local4 Mod $04)
            EndIf
            local1 = ($12 - local1)
            If (local16 <> Null) Then
                Select local3
                    Case "maintenance tunnel endroom"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $01
                    Case "maintenance tunnel corridor"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $02
                    Case "maintenance tunnel corner"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $03
                    Case "maintenance tunnel t-shaped room"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $04
                    Case "maintenance tunnel 4-way room"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $05
                    Case "maintenance tunnel elevator"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $06
                    Case "maintenance tunnel generator room"
                        local16\Field33\Field0[((local2 * $13) + local1)] = $07
                End Select
                local16\Field33\Field1[((local2 * $13) + local1)] = local4
                debuglog((((("created mtunnel piece " + chr($22)) + local3) + chr($22)) + " successfully"))
            EndIf
        Next
    Else
        i_zone\Field0[$00] = $0D
        i_zone\Field0[$01] = $07
        i_zone\Field1 = $00
        i_zone\Field2 = $00
        While (eof(local0) = $00)
            local1 = readbyte(local0)
            local2 = readbyte(local0)
            local3 = lower(readstring(local0))
            local4 = (Int ((Float readbyte(local0)) * 90.0))
            debuglog((((((Str local1) + ", ") + (Str local2)) + ": ") + local3))
            debuglog(("angle: " + (Str local4)))
            For local7 = Each roomtemplates
                If (lower(local7\Field11) = local3) Then
                    local6 = createroom($00, local7\Field10, ((Float (mapwidth - local1)) * 8.0), 0.0, ((Float local2) * 8.0), local3)
                    debuglog("createroom")
                    local6\Field6 = local4
                    If (((local6\Field6 <> $5A) And (local6\Field6 <> $10E)) <> 0) Then
                        local6\Field6 = (local6\Field6 + $B4)
                    EndIf
                    local6\Field6 = (Int wrapangle((Float local6\Field6)))
                    turnentity(local6\Field2, 0.0, (Float local6\Field6), 0.0, $00)
                    maptemp((mapwidth - local1), local2) = $01
                    Exit
                EndIf
            Next
            local3 = readstring(local0)
            local5 = readfloat(local0)
            If (local6 <> Null) Then
                If (0.0 < local5) Then
                    If (local5 >= rnd(0.0, 1.0)) Then
                        local8 = (New events)
                        local8\Field0 = local3
                        local8\Field1 = local6
                        seteventvar(local8)
                        local8\Field22 = findeventconst(local8\Field0)
                    EndIf
                ElseIf (((0.0 = local5) And (local3 <> "")) <> 0) Then
                    local8 = (New events)
                    local8\Field0 = local3
                    local8\Field1 = local6
                    seteventvar(local8)
                    local8\Field22 = findeventconst(local8\Field0)
                EndIf
            EndIf
        Wend
    EndIf
    closefile(local0)
    local18 = $00
    local20 = 8.0
    local21 = $00
    local2 = mapheight
    While (local2 >= $00)
        If (local2 < i_zone\Field0[$01]) Then
            local19 = $03
        ElseIf (((local2 >= i_zone\Field0[$01]) And (local2 < i_zone\Field0[$00])) <> 0) Then
            local19 = $02
        Else
            local19 = $01
        EndIf
        local1 = mapwidth
        While (local1 >= $00)
            If (maptemp(local1, local2) > $00) Then
                If (local19 = $02) Then
                    local18 = $02
                Else
                    local18 = $00
                EndIf
                For local6 = Each rooms
                    local6\Field6 = (Int wrapangle((Float local6\Field6)))
                    If ((((Int (local6\Field3 / 8.0)) = local1) And ((Int (local6\Field5 / 8.0)) = local2)) <> 0) Then
                        local21 = $00
                        Select local6\Field7\Field10
                            Case $01
                                If (local6\Field6 = $5A) Then
                                    local21 = $01
                                EndIf
                            Case $02
                                If (((local6\Field6 = $5A) Or (local6\Field6 = $10E)) <> 0) Then
                                    local21 = $01
                                EndIf
                            Case $03
                                If (((local6\Field6 = $00) Or (local6\Field6 = $5A)) <> 0) Then
                                    local21 = $01
                                EndIf
                            Case $04
                                If ((((local6\Field6 = $00) Or (local6\Field6 = $B4)) Or (local6\Field6 = $5A)) <> 0) Then
                                    local21 = $01
                                EndIf
                            Default
                                local21 = $01
                        End Select
                        If (local21 <> 0) Then
                            If ((local1 + $01) < (mapwidth + $01)) Then
                                If (maptemp((local1 + $01), local2) > $00) Then
                                    local22 = createdoor(local6\Field0, (((Float local1) * local20) + (local20 / 2.0)), 0.0, ((Float local2) * local20), 90.0, local6, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local18, $00, "", $00)
                                    local6\Field35[$00] = local22
                                EndIf
                            EndIf
                        EndIf
                        local21 = $00
                        Select local6\Field7\Field10
                            Case $01
                                If (local6\Field6 = $B4) Then
                                    local21 = $01
                                EndIf
                            Case $02
                                If (((local6\Field6 = $00) Or (local6\Field6 = $B4)) <> 0) Then
                                    local21 = $01
                                EndIf
                            Case $03
                                If (((local6\Field6 = $B4) Or (local6\Field6 = $5A)) <> 0) Then
                                    local21 = $01
                                EndIf
                            Case $04
                                If ((((local6\Field6 = $B4) Or (local6\Field6 = $5A)) Or (local6\Field6 = $10E)) <> 0) Then
                                    local21 = $01
                                EndIf
                            Default
                                local21 = $01
                        End Select
                        If (local21 <> 0) Then
                            If ((local2 + $01) < (mapheight + $01)) Then
                                If (maptemp(local1, (local2 + $01)) > $00) Then
                                    local22 = createdoor(local6\Field0, ((Float local1) * local20), 0.0, (((Float local2) * local20) + (local20 / 2.0)), 0.0, local6, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local18, $00, "", $00)
                                    local6\Field35[$03] = local22
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local1 = (local1 + $FFFFFFFF)
        Wend
        local2 = (local2 + $FFFFFFFF)
    Wend
    local6 = createroom($00, $01, 8.0, 0.0, (Float ((mapheight + $02) Shl $03)), "173")
    local6 = createroom($00, $01, (Float ((mapwidth + $02) Shl $03)), 0.0, (Float ((mapheight + $02) Shl $03)), "pocketdimension")
    local6 = createroom($00, $01, 0.0, 500.0, -16.0, "gatea")
    local6 = createroom($00, $01, -16.0, 800.0, 0.0, "dimension1499")
    createevent("173", "173", $00, 0.0)
    createevent("pocketdimension", "pocketdimension", $00, 0.0)
    createevent("gatea", "gatea", $00, 0.0)
    createevent("dimension1499", "dimension1499", $00, 0.0)
    For local6 = Each rooms
        local6\Field34[$00] = Null
        local6\Field34[$01] = Null
        local6\Field34[$02] = Null
        local6\Field34[$03] = Null
        For local25 = Each rooms
            If (local6 <> local25) Then
                If (local6\Field5 = local25\Field5) Then
                    If ((local6\Field3 + 8.0) = local25\Field3) Then
                        local6\Field34[$00] = local25
                        If (local6\Field35[$00] = Null) Then
                            local6\Field35[$00] = local25\Field35[$02]
                        EndIf
                    ElseIf ((local6\Field3 - 8.0) = local25\Field3) Then
                        local6\Field34[$02] = local25
                        If (local6\Field35[$02] = Null) Then
                            local6\Field35[$02] = local25\Field35[$00]
                        EndIf
                    EndIf
                ElseIf (local6\Field3 = local25\Field3) Then
                    If ((local6\Field5 - 8.0) = local25\Field5) Then
                        local6\Field34[$01] = local25
                        If (local6\Field35[$01] = Null) Then
                            local6\Field35[$01] = local25\Field35[$03]
                        EndIf
                    ElseIf ((local6\Field5 + 8.0) = local25\Field5) Then
                        local6\Field34[$03] = local25
                        If (local6\Field35[$03] = Null) Then
                            local6\Field35[$03] = local25\Field35[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local6\Field34[$00] <> Null) And (local6\Field34[$01] <> Null)) And (local6\Field34[$02] <> Null)) And (local6\Field34[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
    Next
    For local1 = $00 To (mapwidth + $01) Step $01
        For local2 = $00 To (mapheight + $01) Step $01
            If (maptemp(local1, local2) > $00) Then
                debuglog((((("MapTemp(" + (Str local1)) + ",") + (Str local2)) + ") = True"))
            Else
                debuglog((((("MapTemp(" + (Str local1)) + ",") + (Str local2)) + ") = False"))
            EndIf
        Next
    Next
    Return $00
End Function

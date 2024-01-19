Function preventroomoverlap%(arg0.rooms)
    Local local0.rooms
    Local local1.rooms
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    If (arg0\Field7\Field19 <> 0) Then
        Return $00
    EndIf
    local2 = $00
    If ((((arg0\Field7\Field11 = "checkpoint1") Or (arg0\Field7\Field11 = "checkpoint2")) Or (arg0\Field7\Field11 = "start")) <> 0) Then
        Return $01
    EndIf
    For local0 = Each rooms
        If (((local0 <> arg0) And (local0\Field7\Field19 = $00)) <> 0) Then
            If (checkroomoverlap(arg0, local0) <> 0) Then
                local2 = $01
                Exit
            EndIf
        EndIf
    Next
    If (local2 = $00) Then
        Return $01
    EndIf
    local2 = $00
    local3 = (Int (arg0\Field3 / 8.0))
    local4 = (Int (arg0\Field5 / 8.0))
    If (arg0\Field7\Field10 = $02) Then
        arg0\Field6 = (arg0\Field6 + $B4)
        rotateentity(arg0\Field2, 0.0, (Float arg0\Field6), 0.0, $00)
        calculateroomextents(arg0)
        For local0 = Each rooms
            If (((local0 <> arg0) And (local0\Field7\Field19 = $00)) <> 0) Then
                If (checkroomoverlap(arg0, local0) <> 0) Then
                    local2 = $01
                    arg0\Field6 = (arg0\Field6 - $B4)
                    rotateentity(arg0\Field2, 0.0, (Float arg0\Field6), 0.0, $00)
                    calculateroomextents(arg0)
                    Exit
                EndIf
            EndIf
        Next
    Else
        local2 = $01
    EndIf
    If (local2 = $00) Then
        debuglog(("ROOM2 turning succesful! " + arg0\Field7\Field11))
        Return $01
    EndIf
    local2 = $01
    For local0 = Each rooms
        If (((local0 <> arg0) And (local0\Field7\Field19 = $00)) <> 0) Then
            If ((((arg0\Field7\Field10 = local0\Field7\Field10) And (arg0\Field0 = local0\Field0)) And (((local0\Field7\Field11 <> "checkpoint1") And (local0\Field7\Field11 <> "checkpoint2")) And (local0\Field7\Field11 <> "start"))) <> 0) Then
                local3 = (Int (arg0\Field3 / 8.0))
                local4 = (Int (arg0\Field5 / 8.0))
                local8 = arg0\Field6
                local6 = (Int (local0\Field3 / 8.0))
                local7 = (Int (local0\Field5 / 8.0))
                local9 = local0\Field6
                local2 = $00
                arg0\Field3 = ((Float local6) * 8.0)
                arg0\Field5 = ((Float local7) * 8.0)
                arg0\Field6 = local9
                positionentity(arg0\Field2, arg0\Field3, arg0\Field4, arg0\Field5, $00)
                rotateentity(arg0\Field2, 0.0, (Float arg0\Field6), 0.0, $00)
                calculateroomextents(arg0)
                local0\Field3 = ((Float local3) * 8.0)
                local0\Field5 = ((Float local4) * 8.0)
                local0\Field6 = local8
                positionentity(local0\Field2, local0\Field3, local0\Field4, local0\Field5, $00)
                rotateentity(local0\Field2, 0.0, (Float local0\Field6), 0.0, $00)
                calculateroomextents(local0)
                For local1 = Each rooms
                    If (local1\Field7\Field19 = $00) Then
                        If (local1 <> arg0) Then
                            If (checkroomoverlap(arg0, local1) <> 0) Then
                                local2 = $01
                                Exit
                            EndIf
                        EndIf
                        If (local1 <> local0) Then
                            If (checkroomoverlap(local0, local1) <> 0) Then
                                local2 = $01
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
                If (local2 <> 0) Then
                    arg0\Field3 = ((Float local3) * 8.0)
                    arg0\Field5 = ((Float local4) * 8.0)
                    arg0\Field6 = local8
                    positionentity(arg0\Field2, arg0\Field3, arg0\Field4, arg0\Field5, $00)
                    rotateentity(arg0\Field2, 0.0, (Float arg0\Field6), 0.0, $00)
                    calculateroomextents(arg0)
                    local0\Field3 = ((Float local6) * 8.0)
                    local0\Field5 = ((Float local7) * 8.0)
                    local0\Field6 = local9
                    positionentity(local0\Field2, local0\Field3, local0\Field4, local0\Field5, $00)
                    rotateentity(local0\Field2, 0.0, (Float local0\Field6), 0.0, $00)
                    calculateroomextents(local0)
                    local2 = $00
                EndIf
            EndIf
        EndIf
    Next
    If (local2 = $00) Then
        debuglog(("Room re-placing successful! " + arg0\Field7\Field11))
        Return $01
    EndIf
    debuglog(("Couldn't fix overlap issue for room " + arg0\Field7\Field11))
    Return $00
    Return $00
End Function

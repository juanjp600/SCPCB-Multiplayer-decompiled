Function createroom.rooms(arg0%, arg1%, arg2#, arg3#, arg4#, arg5$)
    Local local0.rooms
    Local local1.roomtemplates
    Local local3%
    Local local4%
    Local local5%
    local0 = (New rooms)
    local0\Field18 = $FFFFFFFF
    local0\Field0 = arg0
    local0\Field65 = findfreeroomid()
    room[local0\Field65] = local0
    local0\Field3 = arg2
    local0\Field4 = arg3
    local0\Field5 = arg4
    Select lower(arg5)
        Case "room079"
            local0\Field78 = 0.302
            local0\Field79 = $01
            local0\Field80 = 6.0
        Case "room106"
            local0\Field78 = 0.0
            local0\Field79 = $01
            local0\Field80 = 7.0
    End Select
    If (arg5 <> "") Then
        arg5 = lower(arg5)
        For local1 = Each roomtemplates
            If (local1\Field11 = arg5) Then
                local0\Field7 = local1
                If (local1\Field0 = $00) Then
                    If (iscoopmode() = $00) Then
                        loadroommesh(local1, local1\Field3)
                    Else
                        loadroommesh(local1, "")
                    EndIf
                EndIf
                local0\Field2 = copyentity(local1\Field0, $00)
                scaleentity(local0\Field2, roomscale, roomscale, roomscale, $00)
                entitytype(local0\Field2, $01, $00)
                entitypickmode(local0\Field2, $02, $01)
                loadroomprops(local0)
                positionentity(local0\Field2, arg2, arg3, arg4, $00)
                fillroom(local0)
                If (local0\Field7\Field18 <> 0) Then
                    addlightcones(local0)
                EndIf
                calculateroomextents(local0)
                Return local0
            EndIf
        Next
    EndIf
    local3 = $00
    For local1 = Each roomtemplates
        For local4 = $00 To $04 Step $01
            If (local1\Field4[local4] = arg0) Then
                If (local1\Field10 = arg1) Then
                    local3 = (local3 + local1\Field12)
                    Exit
                EndIf
            EndIf
        Next
    Next
    local5 = rand(local3, $01)
    local3 = $00
    For local1 = Each roomtemplates
        For local4 = $00 To $04 Step $01
            If (((local1\Field4[local4] = arg0) And (local1\Field10 = arg1)) <> 0) Then
                local3 = (local3 + local1\Field12)
                If (((local5 > (local3 - local1\Field12)) And (local5 <= local3)) <> 0) Then
                    local0\Field7 = local1
                    If (local1\Field0 = $00) Then
                        If (iscoopmode() = $00) Then
                            loadroommesh(local1, local1\Field3)
                        Else
                            loadroommesh(local1, "")
                        EndIf
                    EndIf
                    local0\Field2 = copyentity(local1\Field0, $00)
                    scaleentity(local0\Field2, roomscale, roomscale, roomscale, $00)
                    entitytype(local0\Field2, $01, $00)
                    entitypickmode(local0\Field2, $02, $01)
                    loadroomprops(local0)
                    positionentity(local0\Field2, arg2, arg3, arg4, $00)
                    fillroom(local0)
                    If (local0\Field7\Field18 <> 0) Then
                        addlightcones(local0)
                    EndIf
                    calculateroomextents(local0)
                    Return local0
                EndIf
            EndIf
        Next
    Next
    Return Null
End Function

Function createroom.rooms(arg0%, arg1%, arg2#, arg3#, arg4#, arg5$, arg6%)
    Local local0.rooms
    Local local1.roomtemplates
    Local local2%
    Local local4%
    Local local5%
    Local local6%
    local0 = (New rooms)
    local2 = rndseed()
    local0\Field18 = $FFFFFFFF
    local0\Field0 = arg0
    local0\Field65 = findfreeroomid()
    room[local0\Field65] = local0
    local0\Field4 = arg2
    local0\Field5 = arg3
    local0\Field6 = arg4
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
                local0\Field8 = local1
                If (arg6 <> 0) Then
                    local0\Field3 = loadmesh_strict(local1\Field2, $00)
                Else
                    If (local1\Field0 = $00) Then
                        If (iscoopmode() = $00) Then
                            loadroommesh(local1, local1\Field3)
                        Else
                            loadroommesh(local1, "")
                        EndIf
                    EndIf
                    local0\Field3 = copyentity(local1\Field0, $00)
                EndIf
                scaleentity(local0\Field3, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitytype(local0\Field3, $01, $00)
                entitypickmode(local0\Field3, $02, $01)
                loadroomprops(local0)
                positionentity(local0\Field3, arg2, arg3, arg4, $00)
                fillroom(local0)
                If (local0\Field8\Field18 <> 0) Then
                    addlightcones(local0)
                EndIf
                calculateroomextents(local0)
                seedrnd(local2)
                Return local0
            EndIf
        Next
    EndIf
    local4 = $00
    For local1 = Each roomtemplates
        For local5 = $00 To $04 Step $01
            If (local1\Field4[local5] = arg0) Then
                If (local1\Field10 = arg1) Then
                    local4 = (local4 + local1\Field12)
                    Exit
                EndIf
            EndIf
        Next
    Next
    local6 = rand(local4, $01)
    local4 = $00
    For local1 = Each roomtemplates
        For local5 = $00 To $04 Step $01
            If (((local1\Field4[local5] = arg0) And (local1\Field10 = arg1)) <> 0) Then
                local4 = (local4 + local1\Field12)
                If (((local6 > (local4 - local1\Field12)) And (local6 <= local4)) <> 0) Then
                    local0\Field8 = local1
                    If (arg6 <> 0) Then
                        local0\Field3 = loadmesh_strict(local1\Field2, $00)
                    Else
                        If (local1\Field0 = $00) Then
                            If (iscoopmode() = $00) Then
                                loadroommesh(local1, local1\Field3)
                            Else
                                loadroommesh(local1, "")
                            EndIf
                        EndIf
                        local0\Field3 = copyentity(local1\Field0, $00)
                    EndIf
                    scaleentity(local0\Field3, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                    entitytype(local0\Field3, $01, $00)
                    entitypickmode(local0\Field3, $02, $01)
                    loadroomprops(local0)
                    positionentity(local0\Field3, arg2, arg3, arg4, $00)
                    fillroom(local0)
                    If (local0\Field8\Field18 <> 0) Then
                        addlightcones(local0)
                    EndIf
                    calculateroomextents(local0)
                    seedrnd(local2)
                    Return local0
                EndIf
            EndIf
        Next
    Next
    Return Null
End Function

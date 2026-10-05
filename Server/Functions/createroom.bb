Function createroom.rooms(arg0%, arg1%, arg2#, arg3#, arg4#, arg5$)
    Local local0.rooms
    Local local1.roomtemplates
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    local0 = (New rooms)
    local2 = rndseed()
    local0\Field18 = $FFFFFFFF
    local0\Field0 = arg0
    local0\Field69 = findfreeroomid()
    room[local0\Field69] = local0
    local0\Field3 = arg2
    local0\Field4 = arg3
    local0\Field5 = arg4
    If (arg5 <> "") Then
        arg5 = lower(arg5)
        For local1 = Each roomtemplates
            If (local1\Field10 = arg5) Then
                local0\Field7 = local1
                If (local1\Field0 = $00) Then
                    loadroommesh(local1)
                EndIf
                local0\Field2 = copyentity(local1\Field0, $00)
                scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitytype(local0\Field2, $01, $00)
                entitypickmode(local0\Field2, $02, $01)
                loadroomprops(local0)
                positionentity(local0\Field2, arg2, arg3, arg4, $00)
                fillroom(local0)
                calculateroomextents(local0)
                seedrnd(local2)
                Return local0
            EndIf
        Next
    EndIf
    local3 = $00
    For local1 = Each roomtemplates
        For local4 = $00 To $04 Step $01
            If (local1\Field3[local4] = arg0) Then
                If (local1\Field9 = arg1) Then
                    local3 = (local3 + local1\Field11)
                    Exit
                EndIf
            EndIf
        Next
    Next
    local5 = rand(local3, $01)
    local3 = $00
    For local1 = Each roomtemplates
        For local4 = $00 To $04 Step $01
            If (((local1\Field3[local4] = arg0) And (local1\Field9 = arg1)) <> 0) Then
                local3 = (local3 + local1\Field11)
                If (((local5 > (local3 - local1\Field11)) And (local5 <= local3)) <> 0) Then
                    local0\Field7 = local1
                    If (local1\Field0 = $00) Then
                        loadroommesh(local1)
                    EndIf
                    local0\Field2 = copyentity(local1\Field0, $00)
                    scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                    entitytype(local0\Field2, $01, $00)
                    entitypickmode(local0\Field2, $02, $01)
                    loadroomprops(local0)
                    positionentity(local0\Field2, arg2, arg3, arg4, $00)
                    fillroom(local0)
                    calculateroomextents(local0)
                    seedrnd(local2)
                    Return local0
                EndIf
            EndIf
        Next
    Next
    Return Null
End Function

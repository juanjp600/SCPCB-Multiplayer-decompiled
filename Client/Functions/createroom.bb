Function createroom.rooms(arg0%, arg1%, arg2#, arg3#, arg4#, arg5%, arg6#)
    Local local0.rooms
    Local local1.roomtemplates
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    catcherrors((((((((((("CreateRoom.Rooms(" + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ")"))
    local0 = (New rooms)
    local0\Field0 = arg0
    local0\Field3 = arg2
    local0\Field4 = arg3
    local0\Field5 = arg4
    mp_initializeroom(local0)
    If (arg5 <> $FFFFFFFF) Then
        For local1 = Each roomtemplates
            If (local1\Field6 = arg5) Then
                local0\Field7 = local1
                local3 = rndseed()
                If (local1\Field0 = $00) Then
                    loadroommesh(local1)
                EndIf
                local0\Field2 = copyentity(local1\Field0, $00)
                scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                entitytype(local0\Field2, $01, $00)
                entitypickmode(local0\Field2, $02, $01)
                positionentity(local0\Field2, arg2, arg3, arg4, $00)
                For local2 = $00 To $1D Step $01
                    local0\Field12[local2] = $00
                Next
                seedrnd(generateseednumber(randomseed))
                fillroom(local0)
                local0\Field6 = (Int arg6)
                rotateentity(local0\Field2, 0.0, arg6, 0.0, $00)
                seedrnd(local3)
                Return local0
            EndIf
        Next
    EndIf
    local4 = $00
    For local1 = Each roomtemplates
        For local2 = $00 To $04 Step $01
            If (local1\Field3[local2] = arg0) Then
                If (local1\Field4 = arg1) Then
                    local4 = (local4 + local1\Field7)
                    Exit
                EndIf
            EndIf
        Next
    Next
    local5 = rand(local4, $01)
    local4 = $00
    For local1 = Each roomtemplates
        For local2 = $00 To $04 Step $01
            If (((local1\Field3[local2] = arg0) And (local1\Field4 = arg1)) <> 0) Then
                local4 = (local4 + local1\Field7)
                If (((local5 > (local4 - local1\Field7)) And (local5 <= local4)) <> 0) Then
                    local0\Field7 = local1
                    local3 = rndseed()
                    If (local1\Field0 = $00) Then
                        loadroommesh(local1)
                    EndIf
                    local0\Field2 = copyentity(local1\Field0, $00)
                    scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                    entitytype(local0\Field2, $01, $00)
                    entitypickmode(local0\Field2, $02, $01)
                    positionentity(local0\Field2, arg2, arg3, arg4, $00)
                    For local2 = $00 To $1D Step $01
                        local0\Field12[local2] = $00
                    Next
                    seedrnd(generateseednumber(randomseed))
                    fillroom(local0)
                    local0\Field6 = (Int arg6)
                    rotateentity(local0\Field2, 0.0, arg6, 0.0, $00)
                    seedrnd(local3)
                    Return local0
                EndIf
            EndIf
        Next
    Next
    catcherrors((((((((((("Uncaught: CreateRoom.Rooms(" + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + "))"))
    Return Null
End Function

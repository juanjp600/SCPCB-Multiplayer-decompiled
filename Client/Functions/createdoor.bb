Function createdoor.doors(arg0.rooms, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%, arg7%, arg8%, arg9%)
    Local local0.doors
    Local local1%
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local14%
    Local local15%
    If (arg0 <> Null) Then
        local1 = arg0\Field2
    Else
        local1 = arg9
    EndIf
    local0 = (New doors)
    local0\Field14 = arg7
    local0\Field19 = arg8
    local0\Field7 = (Int arg4)
    local0\Field6 = arg5
    local0\Field10 = arg6
    local0\Field23 = $01
    local0\Field20 = ((((arg5 And ((arg6 = $00) Lor (arg6 = $02))) And (arg7 = $00)) And (arg8 = $00)) And (rand($0A, $01) = $01))
    local0\Field15 = arg0
    Select arg6
        Case $00
            local10 = $00
            local11 = local10
            local6 = ((1.0 / 1.261084) / meshwidth(d_i\Field0[local10]))
            local7 = (1.222656 / meshheight(d_i\Field0[local10]))
            local8 = ((1.0 / 17.06667) / meshdepth(d_i\Field0[local10]))
            local9 = $00
            local3 = (1.0 / 256.0)
            local4 = (1.0 / 256.0)
            local5 = (1.0 / 256.0)
        Case $06,$07
            local10 = $08
            local11 = local10
            local6 = ((1.0 / 1.261084) / meshwidth(d_i\Field0[local10]))
            local7 = (1.222656 / meshheight(d_i\Field0[local10]))
            local8 = ((1.0 / 17.06667) / meshdepth(d_i\Field0[local10]))
            local9 = $00
            local3 = (1.0 / 256.0)
            local4 = (1.0 / 256.0)
            local5 = (1.0 / 256.0)
        Case $01
            local10 = $01
            local11 = local10
            local6 = (1.0 / 256.0)
            local7 = (1.0 / 256.0)
            local8 = (1.0 / 256.0)
            local9 = $00
            local3 = (1.0 / 256.0)
            local4 = (1.0 / 256.0)
            local5 = (1.0 / 256.0)
            local0\Field4 = $01
        Case $02
            local10 = $02
            local11 = $03
            local6 = (1.0 / 256.0)
            local7 = (1.0 / 256.0)
            local8 = (1.0 / 256.0)
            local9 = $00
            local3 = (1.0 / 256.0)
            local4 = (1.0 / 256.0)
            local5 = (1.0 / 256.0)
        Case $03
            local10 = $04
            local11 = $05
            local6 = (1.0 / 4.654545)
            local7 = (1.0 / 4.654545)
            local8 = (1.0 / 4.654545)
            local9 = $01
            local3 = (1.0 / 4.654545)
            local4 = (1.0 / 4.654545)
            local5 = (1.0 / 4.654545)
        Case $04
            local10 = $06
            local6 = (1.0 / 256.0)
            local7 = (1.0 / 256.0)
            local8 = (1.0 / 256.0)
            local9 = $02
            local3 = (1.0 / 256.0)
            local4 = (1.0 / 256.0)
            local5 = (1.0 / 256.0)
        Case $05
            local10 = $07
            local6 = (1.0 / 5.565217)
            local7 = 0.171875
            local8 = (1.0 / 5.565217)
            local9 = $03
            local3 = (1.0 / 5.688889)
            local4 = 0.171875
            local5 = (1.0 / 3.2)
    End Select
    local14 = (arg6 = $03)
    local0\Field2 = copyentity(d_i\Field1[local9], $00)
    scaleentity(local0\Field2, local3, local4, local5, $00)
    positionentity(local0\Field2, arg1, arg2, arg3, $00)
    If (local14 <> 0) Then
        entitytype(local0\Field2, $01, $00)
    EndIf
    entitypickmode(local0\Field2, $02, $01)
    local0\Field0 = copyentity(d_i\Field0[local10], $00)
    scaleentity(local0\Field0, local6, local7, local8, $00)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    rotateentity(local0\Field0, 0.0, arg4, 0.0, $00)
    entitytype(local0\Field0, $01, $00)
    entitypickmode(local0\Field0, $02, $01)
    entityparent(local0\Field0, local1, $01)
    local15 = ((arg6 = $04) Lor (arg6 = $05))
    If (local15 = $00) Then
        local0\Field1 = copyentity(d_i\Field0[local11], $00)
        scaleentity(local0\Field1, local6, local7, local8, $00)
        positionentity(local0\Field1, arg1, arg2, arg3, $00)
        rotateentity(local0\Field1, 0.0, (((Float (local14 = $00)) * 180.0) + arg4), 0.0, $00)
        entitytype(local0\Field1, $01, $00)
        entitypickmode(local0\Field1, $02, $01)
        entityparent(local0\Field1, local1, $01)
    EndIf
    For local2 = $00 To $01 Step $01
        If (local15 <> 0) Then
            local0\Field3[local2] = createpivot($00)
            positionentity(local0\Field3[local2], (arg1 - 0.22), (arg2 + 0.6), ((arg3 + 0.1) + ((Float local2) * -0.2)), $00)
            entityradius(local0\Field3[local2], 0.1, 0.0)
            entitypickmode(local0\Field3[local2], $01, $01)
            entityparent(local0\Field3[local2], local0\Field2, $01)
        Else
            If (arg8 <> $00) Then
                local12 = $02
            ElseIf (arg7 > $00) Then
                local12 = $01
            ElseIf (((arg7 > $FFFFFFFC) And (arg7 < $00)) <> 0) Then
                local12 = $03
            Else
                local12 = $00
                If (arg6 = $01) Then
                    local12 = (local2 Shl $02)
                    local0\Field24[local2] = copyentity(d_i\Field4, $00)
                    scaleentity(local0\Field24[local2], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
                    rotateentity(local0\Field24[local2], 0.0, ((Float local2) * 180.0), 0.0, $00)
                    positionentity(local0\Field24[local2], arg1, (arg2 + 1.27), ((arg3 + 0.13) + ((Float local2) * -0.26)), $00)
                    entityparent(local0\Field24[local2], local0\Field2, $01)
                EndIf
            EndIf
            local0\Field3[local2] = createbutton(local12, ((((((Float local2) * -1.2) + 0.6) * (Float (local14 = $00))) + arg1) + (((((Float local2) * 864.0) + -432.0) * (1.0 / 256.0)) * (Float local14))), (arg2 + 0.7), ((((((Float local2) * 0.2) + -0.1) * (Float (local14 = $00))) + arg3) + (((((Float local2) * -384.0) + 192.0) * (Float local14)) * (1.0 / 256.0))), 0.0, ((((Float local2) * 180.0) * (Float (local14 = $00))) + ((((Float local2) * 180.0) + 90.0) * (Float local14))), 0.0, local0\Field2, local0\Field4)
        EndIf
    Next
    rotateentity(local0\Field2, 0.0, arg4, 0.0, $00)
    entityparent(local0\Field2, local1, $01)
    mp_initializedoor(local0)
    Return local0
    Return Null
End Function

Function mat_initreflections%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11#
    Local local12#
    Local local13#
    Local local14#
    env_reflective = createtexture(arg0, arg1, ((arg2 + $40) + $00), $01)
    textureblend(env_reflective, $03)
    local0 = texturebuffer(env_reflective, $00)
    setbuffer(local0)
    lockbuffer(local0)
    local1 = ((Float arg0) * 0.5)
    local2 = ((Float arg1) * 0.3)
    local3 = ((Float arg0) * 0.3)
    local4 = ((Float arg1) * 0.4)
    local5 = $14
    For local7 = $00 To (arg1 - $01) Step $01
        For local6 = $00 To (arg0 - $01) Step $01
            local11 = (((Float local6) - local1) / local3)
            local12 = (((Float local7) - local2) / local4)
            local13 = sqr(((local11 * local11) + (local12 * local12)))
            If (1.0 > local13) Then
                local14 = (1.0 - local13)
                local8 = (Int (local14 * (Float local5)))
                local9 = local8
                local10 = local8
            Else
                local8 = $00
                local9 = $00
                local10 = $00
            EndIf
            writepixelfast(local6, local7, ((local10 Or (local9 Shl $08)) Or (local8 Shl $10)), local0)
        Next
    Next
    unlockbuffer(local0)
    Return $00
End Function

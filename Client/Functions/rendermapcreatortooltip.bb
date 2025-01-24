Function rendermapcreatortooltip%(arg0%, arg1%, arg2%, arg3%, arg4$)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5$[6]
    Local local6$
    Local local7%
    Local local8$
    Local local9$
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    local0 = ((6.0 * menuscale) + (Float arg0))
    local1 = ((6.0 * menuscale) + (Float arg1))
    local2 = ((Float arg2) - (12.0 * menuscale))
    local3 = ((Float arg3) - (12.0 * menuscale))
    local4 = $00
    setfontex(fo\Field0[$00])
    color($FF, $FF, $FF)
    If (right(arg4, $06) = "cbmap2") Then
        local6 = converttoutf8(arg4)
        local5[$00] = left(local6, (len(local6) - $07))
        local7 = openfile_strict(("Map Creator\Maps\" + arg4))
        local8 = converttoutf8(readline(local7))
        local9 = converttoutf8(readline(local7))
        readbyte(local7)
        readbyte(local7)
        local10 = readint(local7)
        local11 = (readint(local7) > $00)
        local12 = (readint(local7) > $00)
        closefile(local7)
    Else
        local5[$00] = left(arg4, (len(arg4) - $06))
        local8 = getlocalstring("creator", "unknown")
        local9 = getlocalstring("creator", "nodesc")
        local10 = $00
        local11 = $00
        local12 = $00
    EndIf
    local5[$01] = format(getlocalstring("creator", "author"), local8, "%s")
    local5[$02] = format(getlocalstring("creator", "desc"), local9, "%s")
    If (local10 > $00) Then
        local5[$03] = format(getlocalstring("creator", "ramount"), (Str local10), "%s")
    Else
        local5[$03] = format(getlocalstring("creator", "ramount"), getlocalstring("creator", "unknown"), "%s")
    EndIf
    If (local11 <> 0) Then
        local5[$04] = format(getlocalstring("creator", "forest"), getlocalstring("creator", "yes"), "%s")
    Else
        local5[$04] = format(getlocalstring("creator", "forest"), getlocalstring("creator", "no"), "%s")
    EndIf
    If (local12 <> 0) Then
        local5[$05] = format(getlocalstring("creator", "mt"), getlocalstring("creator", "yes"), "%s")
    Else
        local5[$05] = format(getlocalstring("creator", "mt"), getlocalstring("creator", "no"), "%s")
    EndIf
    local13 = stringheight(local5[$00])
    local14 = stringheight(local5[$02])
    local15 = (Int (5.0 * menuscale))
    local4 = getlineamount(local5[$02], (Int local2), (Int local3), 1.0)
    renderframe(arg0, arg1, arg2, (((local13 * $06) + (local14 * local4)) + local15), $00, $00, $00)
    color($FF, $FF, $FF)
    textex((Int local0), (Int local1), local5[$00], $00, $00)
    textex((Int local0), (Int (local1 + (Float local13))), local5[$01], $00, $00)
    rowtext(local5[$02], (Int local0), (Int (local1 + (Float (local13 Shl $01)))), (Int local2), (Int local3), $00, 1.0)
    textex((Int local0), (Int ((Float (((local13 Shl $01) + (local14 * local4)) + local15)) + local1)), local5[$03], $00, $00)
    textex((Int local0), (Int ((Float (((local13 * $03) + (local14 * local4)) + local15)) + local1)), local5[$04], $00, $00)
    textex((Int local0), (Int ((Float (((local13 Shl $02) + (local14 * local4)) + local15)) + local1)), local5[$05], $00, $00)
    Return $00
End Function

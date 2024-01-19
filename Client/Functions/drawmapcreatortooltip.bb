Function drawmapcreatortooltip%(arg0%, arg1%, arg2%, arg3%, arg4$)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5$[5]
    Local local6%
    Local local7$
    Local local8$
    Local local9%
    Local local10%
    Local local11%
    local0 = ((6.0 * menuscale) + (Float arg0))
    local1 = ((6.0 * menuscale) + (Float arg1))
    local2 = ((Float arg2) - (12.0 * menuscale))
    local3 = ((Float arg3) - (12.0 * menuscale))
    local4 = $00
    aasetfont(font1)
    color($FF, $FF, $FF)
    If (right(arg4, $06) = "cbmap2") Then
        local5[$00] = left(arg4, (len(arg4) - $07))
        local6 = openfile(("Map Creator\Maps\" + arg4))
        local7 = readline(local6)
        local8 = readline(local6)
        readbyte(local6)
        readbyte(local6)
        local9 = readint(local6)
        If (readint(local6) > $00) Then
            local10 = $01
        Else
            local10 = $00
        EndIf
        If (readint(local6) > $00) Then
            local11 = $01
        Else
            local11 = $00
        EndIf
        closefile(local6)
    Else
        local5[$00] = left(arg4, (len(arg4) - $06))
        local7 = "[Unknown]"
        local8 = "[No description]"
        local9 = $00
        local10 = $00
        local11 = $00
    EndIf
    local5[$01] = ("Made by: " + local7)
    local5[$02] = ("Description: " + local8)
    If (local9 > $00) Then
        local5[$03] = ("Room amount: " + (Str local9))
    Else
        local5[$03] = "Room amount: [Unknown]"
    EndIf
    If (local10 <> 0) Then
        local5[$04] = "Has custom forest: Yes"
    Else
        local5[$04] = "Has custom forest: No"
    EndIf
    If (local11 <> 0) Then
        local5[$05] = "Has custom maintenance tunnel: Yes"
    Else
        local5[$05] = "Has custom maintenance tunnel: No"
    EndIf
    local4 = getlineamount(local5[$02], (Int local2), (Int local3), 1.0)
    drawframe(arg0, arg1, arg2, (Int ((Float ((aastringheight(local5[$00]) * $06) + (aastringheight(local5[$02]) * local4))) + (5.0 * menuscale))), $00, $00)
    color($FF, $FF, $FF)
    aatext((Int local0), (Int local1), local5[$00], $00, $00, 1.0)
    aatext((Int local0), (Int (local1 + (Float aastringheight(local5[$00])))), local5[$01], $00, $00, 1.0)
    rowtext(local5[$02], local0, (local1 + (Float (aastringheight(local5[$00]) Shl $01))), local2, local3, $00, 1.0, $00)
    aatext((Int local0), (Int (((Float ((aastringheight(local5[$00]) Shl $01) + (aastringheight(local5[$02]) * local4))) + (5.0 * menuscale)) + local1)), local5[$03], $00, $00, 1.0)
    aatext((Int local0), (Int (((Float ((aastringheight(local5[$00]) * $03) + (aastringheight(local5[$02]) * local4))) + (5.0 * menuscale)) + local1)), local5[$04], $00, $00, 1.0)
    aatext((Int local0), (Int (((Float ((aastringheight(local5[$00]) Shl $02) + (aastringheight(local5[$02]) * local4))) + (5.0 * menuscale)) + local1)), local5[$05], $00, $00, 1.0)
    Return $00
End Function

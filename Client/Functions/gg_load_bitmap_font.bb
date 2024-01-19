Function gg_load_bitmap_font.tgg_font(arg0$, arg1$)
    Local local0%
    Local local1%
    Local local2%
    Local local3$
    Local local4$
    Local local5$
    Local local6.tgg_character
    Local local7%
    Local local8%
    Local local9.tgg_font
    If (filetype(arg1) = $00) Then
        runtimeerror(("GG_Load_Bitmap_Font cannot find " + arg1))
    EndIf
    local5 = replace(arg1, ".ggfnt", ".png")
    If (filetype(local5) = $01) Then
        local4 = local5
    Else
        local4 = replace(arg1, ".ggfnt", ".bmp")
        If (filetype(local4) = $00) Then
            runtimeerror(("GG_Load_Bitmap_Font() could not find a bitmap image for " + arg1))
        EndIf
    EndIf
    local0 = readfile(arg1)
    local5 = readline(local0)
    local1 = (Int mid(local5, (instr(local5, "=", $01) + $01), $FFFFFFFF))
    local5 = readline(local0)
    local2 = (Int mid(local5, (instr(local5, "=", $01) + $01), $FFFFFFFF))
    local8 = loadanimtexture(local4, $136, local1, local1, $00, local2)
    local9 = (New tgg_font)
    local9\Field0 = arg0
    local9\Field1 = local8
    For local7 = $00 To (local2 - $01) Step $01
        local5 = readline(local0)
        local6 = (New tgg_character)
        local6\Field0 = local7
        local6\Field1 = local9
        local6\Field2 = left(local5, $01)
        local6\Field3 = (Float mid(local5, $03, $FFFFFFFF))
        local6\Field4 = createsprite($00)
        spriteviewmode(local6\Field4, $02)
        entitytexture(local6\Field4, local8, local7, $00)
        hideentity(local6\Field4)
        local9\Field2 = (local9\Field2 + local6\Field2)
    Next
    local6 = (New tgg_character)
    local6\Field0 = local2
    local6\Field1 = local9
    local6\Field2 = "DUMMY"
    local6\Field3 = 10.0
    local6\Field4 = createsprite($00)
    entityalpha(local6\Field4, 0.0)
    hideentity(local6\Field4)
    closefile(local0)
    gg_ocurrent_font = local9
    Return local9
    Return Null
End Function

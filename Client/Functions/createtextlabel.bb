Function createtextlabel%(arg0$, arg1#)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    local0 = stringwidth(arg0)
    local1 = stringheight(arg0)
    local2 = (local0 Shr $01)
    local3 = (local1 Shr $01)
    local4 = createimageflag(local0, local1, $01, $02)
    setbuffer(imagebuffer(local4, $00))
    clscolor($00, $00, $00, $00)
    cls()
    color($00, $00, $00, $FF)
    text((local2 + $01), (local3 + $01), arg0, $01, $01)
    color($FF, $FF, $FF, $FF)
    text(local2, local3, arg0, $01, $01)
    setbuffer(backbuffer())
    local5 = createtexture(local0, local1, $33, $01)
    copyrect($00, $00, local0, local1, $00, $00, imagebuffer(local4, $00), texturebuffer(local5, $00))
    local6 = createsprite($00)
    scalesprite(local6, ((Float local0) * arg1), ((Float local1) * arg1))
    spriteviewmode(local6, $04)
    entitytexture(local6, local5, $00, $00)
    entityfx(local6, $09)
    freetexture(local5)
    freeimage(local4)
    Return local6
    Return $00
End Function

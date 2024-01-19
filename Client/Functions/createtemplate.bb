Function createtemplate%()
    Local local0.template
    Local local1%
    local0 = (New template)
    local1 = (Handle local0)
    settemplateemitterblend(local1, $03)
    settemplateinterval(local1, $01)
    settemplateparticlesperinterval(local1, $01)
    settemplatemaxparticles(local1, $FFFFFFFF)
    settemplateemitterlifetime(local1, $64)
    settemplateparticlelifetime(local1, $00, $14)
    settemplatealpha(local1, 1.0)
    settemplatesize(local1, 1.0, 1.0, 1.0, 1.0)
    settemplatesizevel(local1, 0.0, 1.0)
    settemplatecolors(local1, $FFFFFF, $FFFFFF)
    settemplatebrightness(local1, $01)
    settemplatefloor(local1, -1000000.0, 0.5)
    settemplatefixangles(local1, $FFFFFFFF, $FFFFFFFF)
    Return (Handle local0)
    Return $00
End Function

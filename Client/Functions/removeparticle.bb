Function removeparticle%(arg0.particles)
    catcherrors("RemoveParticle()")
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    freeentity(arg0\Field1)
    arg0\Field1 = $00
    Delete arg0
    catcherrors("Uncaught: RemoveParticles()")
    Return $00
End Function

set(COCOS_EXTENSIONS_HEADER
    ../extensions/ExtensionMacros.h
    ../extensions/assets-manager/AssetsManagerEx.h
    ../extensions/assets-manager/Manifest.h
    ../extensions/assets-manager/CCEventListenerAssetsManagerEx.h
    ../extensions/assets-manager/AssetsManager.h
    ../extensions/assets-manager/CCEventAssetsManagerEx.h
    ../extensions/physics-nodes/CCPhysicsSprite.h
    ../extensions/physics-nodes/CCPhysicsDebugNode.h
    ../extensions/Particle3D/CCParticleSystem3D.h
    ../extensions/Particle3D/PU/CCPUDoExpireEventHandler.h
    ../extensions/Particle3D/PU/CCPUParticleSystem3D.h
    ../extensions/Particle3D/PU/CCPUDoStopSystemEventHandler.h
    ../extensions/Particle3D/PU/CCPUAffectorManager.h
    ../extensions/Particle3D/PU/CCPUTechniqueTranslator.h
    ../extensions/Particle3D/PU/CCPURender.h
    ../extensions/Particle3D/PU/CCPUObserver.h
    ../extensions/Particle3D/PU/CCPUMeshSurfaceEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUAlignAffector.h
    ../extensions/Particle3D/PU/CCPUSphereColliderTranslator.h
    ../extensions/Particle3D/PU/CCPUAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUTextureRotator.h
    ../extensions/Particle3D/PU/CCPUTextureRotatorTranslator.h
    ../extensions/Particle3D/PU/CCPUParticleSystem3DTranslator.h
    ../extensions/Particle3D/PU/CCPUCircleEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPURandomiser.h
    ../extensions/Particle3D/PU/CCPUBoxCollider.h
    ../extensions/Particle3D/PU/CCPUScriptCompiler.h
    ../extensions/Particle3D/PU/CCPUDynamicAttributeTranslator.h
    ../extensions/Particle3D/PU/CCPUOnRandomObserver.h
    ../extensions/Particle3D/PU/CCPUOnCollisionObserver.h
    ../extensions/Particle3D/PU/CCPUBoxEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUDoAffectorEventHandler.h
    ../extensions/Particle3D/PU/CCPUEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPULineEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUMaterialTranslator.h
    ../extensions/Particle3D/PU/CCPUVelocityMatchingAffector.h
    ../extensions/Particle3D/PU/CCPUEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUOnCountObserver.h
    ../extensions/Particle3D/PU/CCPUScriptParser.h
    ../extensions/Particle3D/PU/CCPUOnEmissionObserver.h
    ../extensions/Particle3D/PU/CCPUBaseForceAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPURibbonTrailRender.h
    ../extensions/Particle3D/PU/CCPUDoPlacementParticleEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUDoScaleEventHandler.h
    ../extensions/Particle3D/PU/CCPUScriptTranslator.h
    ../extensions/Particle3D/PU/CCPURandomiserTranslator.h
    ../extensions/Particle3D/PU/CCPUBoxEmitter.h
    ../extensions/Particle3D/PU/CCPUPlaneColliderTranslator.h
    ../extensions/Particle3D/PU/CCPUVortexAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUUtil.h
    ../extensions/Particle3D/PU/CCPUListener.h
    ../extensions/Particle3D/PU/CCPUGravityAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUDoEnableComponentEventHandler.h
    ../extensions/Particle3D/PU/CCPUInterParticleCollider.h
    ../extensions/Particle3D/PU/CCPUDoStopSystemEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUPositionEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUGeometryRotator.h
    ../extensions/Particle3D/PU/CCPUOnEventFlagObserver.h
    ../extensions/Particle3D/PU/CCPULinearForceAffector.h
    ../extensions/Particle3D/PU/CCPUOnTimeObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUBillboardChain.h
    ../extensions/Particle3D/PU/CCPUScaleVelocityAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUParticleFollower.h
    ../extensions/Particle3D/PU/CCPUPositionEmitter.h
    ../extensions/Particle3D/PU/CCPUTextureAnimatorTranslator.h
    ../extensions/Particle3D/PU/CCPUPlaneCollider.h
    ../extensions/Particle3D/PU/CCPUBehaviour.h
    ../extensions/Particle3D/PU/CCPUOnQuotaObserver.h
    ../extensions/Particle3D/PU/CCPULineAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUJetAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUDoEnableComponentEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUForceFieldAffector.h
    ../extensions/Particle3D/PU/CCPUDoFreezeEventHandler.h
    ../extensions/Particle3D/PU/CCPUOnClearObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUAffector.h
    ../extensions/Particle3D/PU/CCPUAlignAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUEmitterManager.h
    ../extensions/Particle3D/PU/CCPUObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUBaseCollider.h
    ../extensions/Particle3D/PU/CCPUParticleFollowerTranslator.h
    ../extensions/Particle3D/PU/CCPUBaseColliderTranslator.h
    ../extensions/Particle3D/PU/CCPUOnVelocityObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUVertexEmitter.h
    ../extensions/Particle3D/PU/CCPUMaterialManager.h
    ../extensions/Particle3D/PU/CCPUScaleAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUSphereSurfaceEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUSphereSurfaceEmitter.h
    ../extensions/Particle3D/PU/CCPUEmitter.h
    ../extensions/Particle3D/PU/CCPUCollisionAvoidanceAffector.h
    ../extensions/Particle3D/PU/CCPUDoFreezeEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUSimpleSpline.h
    ../extensions/Particle3D/PU/CCPUFlockCenteringAffector.h
    ../extensions/Particle3D/PU/CCPUOnExpireObserverTranslator.h
    ../extensions/Particle3D/PU/CCPULineEmitter.h
    ../extensions/Particle3D/PU/CCPUDoAffectorEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUTextureAnimator.h
    ../extensions/Particle3D/PU/CCPUSineForceAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUCircleEmitter.h
    ../extensions/Particle3D/PU/CCPUSlaveBehaviour.h
    ../extensions/Particle3D/PU/CCPUOnPositionObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUOnEventFlagObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUScriptLexer.h
    ../extensions/Particle3D/PU/CCPUOnExpireObserver.h
    ../extensions/Particle3D/PU/CCPUOnRandomObserverTranslator.h
    ../extensions/Particle3D/PU/CCPURibbonTrail.h
    ../extensions/Particle3D/PU/CCPUColorAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUEventHandler.h
    ../extensions/Particle3D/PU/CCPUNoise.h
    ../extensions/Particle3D/PU/CCPUEventHandlerManager.h
    ../extensions/Particle3D/PU/CCPUSlaveBehaviourTranslator.h
    ../extensions/Particle3D/PU/CCPUColorAffector.h
    ../extensions/Particle3D/PU/CCPUScaleVelocityAffector.h
    ../extensions/Particle3D/PU/CCPUDynamicAttribute.h
    ../extensions/Particle3D/PU/CCPUSphere.h
    ../extensions/Particle3D/PU/CCPUSlaveEmitter.h
    ../extensions/Particle3D/PU/CCPUBaseForceAffector.h
    ../extensions/Particle3D/PU/CCPUVelocityMatchingAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUDoScaleEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUGravityAffector.h
    ../extensions/Particle3D/PU/CCPUBeamRender.h
    ../extensions/Particle3D/PU/CCPUOnClearObserver.h
    ../extensions/Particle3D/PU/CCPUOnEmissionObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUJetAffector.h
    ../extensions/Particle3D/PU/CCPUSphereCollider.h
    ../extensions/Particle3D/PU/CCPUPathFollowerTranslator.h
    ../extensions/Particle3D/PU/CCPUOnQuotaObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUPointEmitter.h
    ../extensions/Particle3D/PU/CCPUCollisionAvoidanceAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUPlane.h
    ../extensions/Particle3D/PU/CCPUGeometryRotatorTranslator.h
    ../extensions/Particle3D/PU/CCPUOnCountObserverTranslator.h
    ../extensions/Particle3D/PU/CCPUDoExpireEventHandlerTranslator.h
    ../extensions/Particle3D/PU/CCPUMeshSurfaceEmitter.h
    ../extensions/Particle3D/PU/CCPULineAffector.h
    ../extensions/Particle3D/PU/CCPUSineForceAffector.h
    ../extensions/Particle3D/PU/CCPUPathFollower.h
    ../extensions/Particle3D/PU/CCPULinearForceAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUObserverManager.h
    ../extensions/Particle3D/PU/CCPUBoxColliderTranslator.h
    ../extensions/Particle3D/PU/CCPUDoPlacementParticleEventHandler.h
    ../extensions/Particle3D/PU/CCPUOnVelocityObserver.h
    ../extensions/Particle3D/PU/CCPUScaleAffector.h
    ../extensions/Particle3D/PU/CCPUInterParticleColliderTranslator.h
    ../extensions/Particle3D/PU/CCPUPointEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUVortexAffector.h
    ../extensions/Particle3D/PU/CCPUTranslateManager.h
    ../extensions/Particle3D/PU/CCPUFlockCenteringAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUOnTimeObserver.h
    ../extensions/Particle3D/PU/CCPUBehaviourManager.h
    ../extensions/Particle3D/PU/CCPUOnCollisionObserverTranslator.h
    ../extensions/Particle3D/PU/CCPURendererTranslator.h
    ../extensions/Particle3D/PU/CCPUSlaveEmitterTranslator.h
    ../extensions/Particle3D/PU/CCPUBehaviourTranslator.h
    ../extensions/Particle3D/PU/CCPUForceField.h
    ../extensions/Particle3D/PU/CCPUForceFieldAffectorTranslator.h
    ../extensions/Particle3D/PU/CCPUOnPositionObserver.h
    ../extensions/Particle3D/CCParticle3DEmitter.h
    ../extensions/Particle3D/CCParticle3DAffector.h
    ../extensions/Particle3D/CCParticle3DRender.h
    ../extensions/cocos-ext.h
    ../extensions/GUI/CCControlExtension/CCControlHuePicker.h
    ../extensions/GUI/CCControlExtension/CCControlUtils.h
    ../extensions/GUI/CCControlExtension/CCControl.h
    ../extensions/GUI/CCControlExtension/CCControlExtensions.h
    ../extensions/GUI/CCControlExtension/CCControlColourPicker.h
    ../extensions/GUI/CCControlExtension/CCControlButton.h
    ../extensions/GUI/CCControlExtension/CCInvocation.h
    ../extensions/GUI/CCControlExtension/CCControlSlider.h
    ../extensions/GUI/CCControlExtension/CCControlStepper.h
    ../extensions/GUI/CCControlExtension/CCControlSaturationBrightnessPicker.h
    ../extensions/GUI/CCControlExtension/CCControlPotentiometer.h
    ../extensions/GUI/CCControlExtension/CCControlSwitch.h
    ../extensions/GUI/CCScrollView/CCTableViewCell.h
    ../extensions/GUI/CCScrollView/CCScrollView.h
    ../extensions/GUI/CCScrollView/CCTableView.h
    ../extensions/ExtensionDeprecated.h
    ../extensions/ExtensionExport.h
    )

set(COCOS_EXTENSIONS_SRC

#    ../extensions/assets-manager/AssetsManager.cpp#
#    ../extensions/assets-manager/AssetsManagerEx.cpp
#    ../extensions/assets-manager/CCEventAssetsManagerEx.cpp
#    ../extensions/assets-manager/CCEventListenerAssetsManagerEx.cpp
#    ../extensions/assets-manager/Manifest.cpp
    ../extensions/GUI/CCControlExtension/CCControl.cpp
    ../extensions/GUI/CCControlExtension/CCControlButton.cpp
    ../extensions/GUI/CCControlExtension/CCControlColourPicker.cpp
    ../extensions/GUI/CCControlExtension/CCControlHuePicker.cpp
    ../extensions/GUI/CCControlExtension/CCControlPotentiometer.cpp
    ../extensions/GUI/CCControlExtension/CCControlSaturationBrightnessPicker.cpp
    ../extensions/GUI/CCControlExtension/CCControlSlider.cpp
    ../extensions/GUI/CCControlExtension/CCControlStepper.cpp
    ../extensions/GUI/CCControlExtension/CCControlSwitch.cpp
    ../extensions/GUI/CCControlExtension/CCControlUtils.cpp
    ../extensions/GUI/CCControlExtension/CCInvocation.cpp
    ../extensions/GUI/CCScrollView/CCScrollView.cpp
    ../extensions/GUI/CCScrollView/CCTableView.cpp
    ../extensions/GUI/CCScrollView/CCTableViewCell.cpp
#    ../extensions/physics-nodes/CCPhysicsDebugNode.cpp
#    ../extensions/physics-nodes/CCPhysicsSprite.cpp
#    ../extensions/Particle3D/CCParticle3DAffector.cpp
#    ../extensions/Particle3D/CCParticle3DEmitter.cpp
#    ../extensions/Particle3D/CCParticle3DRender.cpp
#    ../extensions/Particle3D/CCParticleSystem3D.cpp
#    ../extensions/Particle3D/PU/CCPUDynamicAttribute.cpp
#    ../extensions/Particle3D/PU/CCPUDynamicAttributeTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUForceField.cpp
#    ../extensions/Particle3D/PU/CCPUMaterialManager.cpp
#    ../extensions/Particle3D/PU/CCPUMaterialTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUNoise.cpp
#    ../extensions/Particle3D/PU/CCPUPlane.cpp
#    ../extensions/Particle3D/PU/CCPURendererTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUScriptCompiler.cpp
#    ../extensions/Particle3D/PU/CCPUScriptLexer.cpp
#    ../extensions/Particle3D/PU/CCPUScriptParser.cpp
#    ../extensions/Particle3D/PU/CCPUScriptTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUSimpleSpline.cpp
#    ../extensions/Particle3D/PU/CCPUSphere.cpp
#    ../extensions/Particle3D/PU/CCPUTechniqueTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUTranslateManager.cpp
#    ../extensions/Particle3D/PU/CCPUUtil.cpp
#    ../extensions/Particle3D/PU/CCPUParticleSystem3D.cpp
#    ../extensions/Particle3D/PU/CCPUParticleSystem3DTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUListener.cpp
#    ../extensions/Particle3D/PU/CCPUAffector.cpp
#    ../extensions/Particle3D/PU/CCPUAffectorManager.cpp
#    ../extensions/Particle3D/PU/CCPUAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUAlignAffector.cpp
#    ../extensions/Particle3D/PU/CCPUAlignAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUBaseCollider.cpp
#    ../extensions/Particle3D/PU/CCPUBaseColliderTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUBaseForceAffector.cpp
#    ../extensions/Particle3D/PU/CCPUBaseForceAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUBoxCollider.cpp
#    ../extensions/Particle3D/PU/CCPUBoxColliderTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUCollisionAvoidanceAffector.cpp
#    ../extensions/Particle3D/PU/CCPUCollisionAvoidanceAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUColorAffector.cpp
#    ../extensions/Particle3D/PU/CCPUColorAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUFlockCenteringAffector.cpp
#    ../extensions/Particle3D/PU/CCPUFlockCenteringAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUForceFieldAffector.cpp
#    ../extensions/Particle3D/PU/CCPUForceFieldAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUGeometryRotator.cpp
#    ../extensions/Particle3D/PU/CCPUGeometryRotatorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUGravityAffector.cpp
#    ../extensions/Particle3D/PU/CCPUGravityAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUInterParticleCollider.cpp
#    ../extensions/Particle3D/PU/CCPUInterParticleColliderTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUJetAffector.cpp
#    ../extensions/Particle3D/PU/CCPUJetAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPULineAffector.cpp
#    ../extensions/Particle3D/PU/CCPULineAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPULinearForceAffector.cpp
#    ../extensions/Particle3D/PU/CCPULinearForceAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUParticleFollower.cpp
#    ../extensions/Particle3D/PU/CCPUParticleFollowerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUPathFollower.cpp
#    ../extensions/Particle3D/PU/CCPUPathFollowerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUPlaneCollider.cpp
#    ../extensions/Particle3D/PU/CCPUPlaneColliderTranslator.cpp
#    ../extensions/Particle3D/PU/CCPURandomiser.cpp
#    ../extensions/Particle3D/PU/CCPURandomiserTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUScaleAffector.cpp
#    ../extensions/Particle3D/PU/CCPUScaleAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUScaleVelocityAffector.cpp
#    ../extensions/Particle3D/PU/CCPUScaleVelocityAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUSineForceAffector.cpp
#    ../extensions/Particle3D/PU/CCPUSineForceAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUSphereCollider.cpp
#    ../extensions/Particle3D/PU/CCPUSphereColliderTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUTextureAnimator.cpp
#    ../extensions/Particle3D/PU/CCPUTextureAnimatorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUTextureRotator.cpp
#    ../extensions/Particle3D/PU/CCPUTextureRotatorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUVelocityMatchingAffector.cpp
#    ../extensions/Particle3D/PU/CCPUVelocityMatchingAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUVortexAffector.cpp
#    ../extensions/Particle3D/PU/CCPUVortexAffectorTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUBoxEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUBoxEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUCircleEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUCircleEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUEmitterManager.cpp
#    ../extensions/Particle3D/PU/CCPUEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPULineEmitter.cpp
#    ../extensions/Particle3D/PU/CCPULineEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUMeshSurfaceEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUMeshSurfaceEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUPointEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUPointEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUPositionEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUPositionEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUSlaveEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUSlaveEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUSphereSurfaceEmitter.cpp
#    ../extensions/Particle3D/PU/CCPUSphereSurfaceEmitterTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUVertexEmitter.cpp
#    ../extensions/Particle3D/PU/CCPURender.cpp
#    ../extensions/Particle3D/PU/CCPUBeamRender.cpp
#    ../extensions/Particle3D/PU/CCPUBillboardChain.cpp
#    ../extensions/Particle3D/PU/CCPURibbonTrail.cpp
#    ../extensions/Particle3D/PU/CCPURibbonTrailRender.cpp
#    ../extensions/Particle3D/PU/CCPUDoAffectorEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoAffectorEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUDoEnableComponentEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoEnableComponentEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUDoExpireEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoExpireEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUDoFreezeEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoFreezeEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUDoPlacementParticleEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoPlacementParticleEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUDoScaleEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoScaleEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUDoStopSystemEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUDoStopSystemEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUEventHandler.cpp
#    ../extensions/Particle3D/PU/CCPUEventHandlerManager.cpp
#    ../extensions/Particle3D/PU/CCPUEventHandlerTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUObserver.cpp
#    ../extensions/Particle3D/PU/CCPUObserverManager.cpp
#    ../extensions/Particle3D/PU/CCPUObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnClearObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnClearObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnCollisionObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnCollisionObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnCountObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnCountObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnEmissionObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnEmissionObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnEventFlagObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnEventFlagObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnExpireObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnExpireObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnPositionObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnPositionObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnQuotaObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnQuotaObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnRandomObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnRandomObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnTimeObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnTimeObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUOnVelocityObserver.cpp
#    ../extensions/Particle3D/PU/CCPUOnVelocityObserverTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUBehaviour.cpp
#    ../extensions/Particle3D/PU/CCPUBehaviourManager.cpp
#    ../extensions/Particle3D/PU/CCPUBehaviourTranslator.cpp
#    ../extensions/Particle3D/PU/CCPUSlaveBehaviour.cpp
#    ../extensions/Particle3D/PU/CCPUSlaveBehaviourTranslator.cpp
    )

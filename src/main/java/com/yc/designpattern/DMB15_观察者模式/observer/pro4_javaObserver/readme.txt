java原生的实现:
   Observable:  主题类/被观察者
              1. 观察者列表   Vector<Observer>
              2。 通知方法，循环观察者列表，通知变更
   Observer:    接口   ->观察者类
            1. 一定有一个回调处理理  update()